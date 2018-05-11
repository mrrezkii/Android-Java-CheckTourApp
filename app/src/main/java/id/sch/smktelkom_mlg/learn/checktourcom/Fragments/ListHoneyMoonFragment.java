package id.sch.smktelkom_mlg.learn.checktourcom.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.learn.checktourcom.R;


public class ListHoneyMoonFragment extends Fragment {


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


        return rootView;
    }


}
