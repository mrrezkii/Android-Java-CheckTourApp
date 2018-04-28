package id.sch.smktelkom_mlg.learn.checktourcom.NavigationFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.learn.checktourcom.R;


public class ListFamilyFragment extends Fragment {

    public ListFamilyFragment() {
        // Required empty public constructor
    }

    public static ListFamilyFragment newInstance(String param1, String param2) {
        ListFamilyFragment fragment = new ListFamilyFragment();
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
        return inflater.inflate(R.layout.fragment_list_family, container, false);
    }
}
