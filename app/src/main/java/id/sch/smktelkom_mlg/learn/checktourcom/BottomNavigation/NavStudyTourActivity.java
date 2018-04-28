package id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import id.sch.smktelkom_mlg.learn.checktourcom.Helper.BottomNavigationBehavior;
import id.sch.smktelkom_mlg.learn.checktourcom.NavigationFragments.KembaliFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.NavigationFragments.ListStudyTourFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.NavigationFragments.ProfilFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.R;

public class NavStudyTourActivity extends AppCompatActivity {
    private ActionBar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.menu_list_study_tour:
                    //toolbar.setTitle("List");
                    fragment = new ListStudyTourFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_kembali:
                    //toolbar.setTitle("Kembali");
                    fragment = new KembaliFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_profil:
                    //toolbar.setTitle("Profil");
                    fragment = new ProfilFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_study_tour);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        //toolbar.setTitle("List");
        loadFragment(new ListStudyTourFragment());
    }

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
    }
}
