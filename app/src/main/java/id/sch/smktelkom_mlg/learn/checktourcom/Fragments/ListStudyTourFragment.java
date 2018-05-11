package id.sch.smktelkom_mlg.learn.checktourcom.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.learn.checktourcom.R;


public class ListStudyTourFragment extends Fragment {


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


        return rootView;
    }
}
