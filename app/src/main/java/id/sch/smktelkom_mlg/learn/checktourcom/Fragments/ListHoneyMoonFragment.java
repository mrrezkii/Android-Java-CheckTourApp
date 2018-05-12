package id.sch.smktelkom_mlg.learn.checktourcom.Fragments;

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

import id.sch.smktelkom_mlg.learn.checktourcom.Adapter.HoneyMoonAdapter;
import id.sch.smktelkom_mlg.learn.checktourcom.Model.HoneyMoonModel;
import id.sch.smktelkom_mlg.learn.checktourcom.R;


public class ListHoneyMoonFragment extends Fragment {

    protected Context context;
    HoneyMoonModel mHoneyMoon;
    List<HoneyMoonModel> mListData = new ArrayList<>();
    RecyclerView.Adapter adapter;
    private RecyclerView listHoneyMoon;
    private LinearLayoutManager linearLayoutManager;
    private HoneyMoonAdapter honeyMoonAdapter;
    private DatabaseReference mData;
    private FirebaseDatabase mDatasFirebase;


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

        listHoneyMoon = rootView.findViewById(R.id.listHoneyMoon);
        linearLayoutManager = new LinearLayoutManager(context);
        honeyMoonAdapter = new HoneyMoonAdapter(getContext());

        listHoneyMoon.setLayoutManager(linearLayoutManager);
        listHoneyMoon.setAdapter(honeyMoonAdapter);

        loadData();


        return rootView;
    }

    private void loadData() {
        mHoneyMoon = new HoneyMoonModel();

        mDatasFirebase = FirebaseDatabase.getInstance();
        mData = mDatasFirebase.getReference("Honeymoon");

        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                honeyMoonAdapter.clear();
                mListData.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mHoneyMoon = snapshot.getValue(HoneyMoonModel.class);
                    Log.d("data", mListData.toString());
                    mListData.add(mHoneyMoon);
                }
                Log.d("data", mListData.toString());
                honeyMoonAdapter.addAll(mListData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
