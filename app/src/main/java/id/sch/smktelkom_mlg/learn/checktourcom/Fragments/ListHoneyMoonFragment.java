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


public class ListHoneyMoonFragment extends Fragment {

    protected Context context;
    DataModel mHoneyMoon;
    List<DataModel> mListData = new ArrayList<>();
    RecyclerView.Adapter adapter;
    private RecyclerView listHoneyMoon;
    private LinearLayoutManager linearLayoutManager;
    private DataAdapter dataAdapter;
    private DatabaseReference mData;
    private FirebaseDatabase mDatasFirebase;
    private ProgressDialog mProgressDialog;


    public ListHoneyMoonFragment() {
        // Required empty public constructor
    }

    public static ListHoneyMoonFragment newInstance(String param1, String param2) {
        ListHoneyMoonFragment fragment = new ListHoneyMoonFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_list_honey_moon, container, false);

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Loading ...");
        mProgressDialog.show();

        listHoneyMoon = rootView.findViewById(R.id.listHoneyMoon);
        linearLayoutManager = new LinearLayoutManager(context);
        dataAdapter = new DataAdapter(getContext());

        listHoneyMoon.setLayoutManager(linearLayoutManager);
        listHoneyMoon.setAdapter(dataAdapter);

        loadData();


        return rootView;
    }

    private void loadData() {
        mHoneyMoon = new DataModel();

        mDatasFirebase = FirebaseDatabase.getInstance();
        mData = mDatasFirebase.getReference("Honeymoon");

        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataAdapter.clear();
                mListData.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mHoneyMoon = snapshot.getValue(DataModel.class);
                    Log.d("data", mListData.toString());
                    mListData.add(mHoneyMoon);
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
