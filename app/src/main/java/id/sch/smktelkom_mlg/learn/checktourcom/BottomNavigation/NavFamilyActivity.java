package id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import id.sch.smktelkom_mlg.learn.checktourcom.Fragments.ListFamilyFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.Fragments.ProfilFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.Helper.BottomNavigationBehavior;
import id.sch.smktelkom_mlg.learn.checktourcom.MainActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.R;

public class NavFamilyActivity extends AppCompatActivity {
    private ActionBar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.menu_list_family:
                    //toolbar.setTitle("List");
                    fragment = new ListFamilyFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.menu_kembali:
                    //toolbar.setTitle("Kembali");
                    Intent kembali = new Intent(NavFamilyActivity.this, MainActivity.class);
                    startActivity(kembali);
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
        setContentView(R.layout.activity_navfamily);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        //toolbar.setTitle("List");
        loadFragment(new ListFamilyFragment());
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
