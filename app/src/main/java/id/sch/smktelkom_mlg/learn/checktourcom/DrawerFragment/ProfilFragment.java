package id.sch.smktelkom_mlg.learn.checktourcom.DrawerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.learn.checktourcom.R;

/**
 * Created by Rezki on 4/28/2018.
 */

public class ProfilFragment extends Fragment {

    public static ProfilFragment newInstance() {
        return new ProfilFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profil, container, false);

        return rootView;
    }
}
