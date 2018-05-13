package id.sch.smktelkom_mlg.learn.checktourcom.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.learn.checktourcom.Adapter.DataAdapter;
import id.sch.smktelkom_mlg.learn.checktourcom.Model.DataModel;
import id.sch.smktelkom_mlg.learn.checktourcom.R;


public class ListStudyTourFragment extends Fragment {

    protected Context context;
    DataModel mStudyTour;
    List<DataModel> mListData = new ArrayList<>();
    RecyclerView.Adapter adapter;
    private RecyclerView listStudyTour;
    private LinearLayoutManager linearLayoutManager;
    private DataAdapter dataAdapter;
    private DatabaseReference mData;
    private FirebaseDatabase mDatasFirebase;
    private ProgressDialog mProgressDialog;


    public ListStudyTourFragment() {
        // Required empty public constructor
    }

    public static ListStudyTourFragment newInstance(String param1, String param2) {
        ListStudyTourFragment fragment = new ListStudyTourFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_study_tour, container, false);

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Loading ...");
        mProgressDialog.show();

        listStudyTour = rootView.findViewById(R.id.listStudyTour);
        linearLayoutManager = new LinearLayoutManager(context);
        dataAdapter = new DataAdapter(getContext());

        listStudyTour.setLayoutManager(linearLayoutManager);
        listStudyTour.setAdapter(dataAdapter);

        loadData();


        return rootView;
    }

    private void loadData() {
        mStudyTour = new DataModel();

        mDatasFirebase = FirebaseDatabase.getInstance();
        mData = mDatasFirebase.getReference("Studytour");

        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataAdapter.clear();
                mListData.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mStudyTour = snapshot.getValue(DataModel.class);
                    Log.d("data", mListData.toString());
                    mListData.add(mStudyTour);
                }
                Log.d("data", mListData.toString());
                dataAdapter.addAll(mListData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
