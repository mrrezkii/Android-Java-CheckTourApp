package id.sch.smktelkom_mlg.learn.checktourcom.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.TimerTask;

import id.sch.smktelkom_mlg.learn.checktourcom.Adapter.MainAdapter;
import id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation.NavFamilyActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation.NavHoneyMoonActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation.NavStudyTourActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.R;

/**
 * Created by Rezki on 4/28/2018.
 */

public class HomeFragment extends Fragment {

    ImageButton btnFamily, btnStudyTour, btnHoneyMoon;
    ViewPager viewPager;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // View Pager START//
        viewPager = rootView.findViewById(R.id.viewPager);

        MainAdapter mainAdapter = new MainAdapter(getContext());

        viewPager.setAdapter(mainAdapter);

        //Timer timer = new Timer();
        //timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        // View Pager END //

        btnFamily = rootView.findViewById(R.id.btnFamily);
        btnStudyTour = rootView.findViewById(R.id.btnStudyTour);
        btnHoneyMoon = rootView.findViewById(R.id.btnHoneyMoon);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveFamily();
            }
        });
        btnStudyTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveStudyTour();
            }
        });
        btnHoneyMoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveHoneyMoon();
            }
        });

        return rootView;
    }

    public void moveFamily() {
        Intent intent = new Intent(getActivity(), NavFamilyActivity.class);
        startActivity(intent);

    }

    public void moveStudyTour() {
        Intent intent = new Intent(getActivity(), NavStudyTourActivity.class);
        startActivity(intent);
    }

    public void moveHoneyMoon() {
        Intent intent = new Intent(getActivity(), NavHoneyMoonActivity.class);
        startActivity(intent);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else {
                        viewPager.setCurrentItem(5);
                    }
                }
            });
        }
    }
}