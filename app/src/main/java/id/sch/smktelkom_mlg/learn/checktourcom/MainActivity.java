package id.sch.smktelkom_mlg.learn.checktourcom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import id.sch.smktelkom_mlg.learn.checktourcom.Adapter.MainAdapter;
import id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation.NavFamilyActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation.NavHoneyMoonActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.BottomNavigation.NavStudyTourActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.DrawerFragments.ProfilFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.DrawerFragments.SettingFragment;
import id.sch.smktelkom_mlg.learn.checktourcom.Toolbar.MainToolbar;

public class MainActivity extends MainToolbar {
    ImageButton btnFamily, btnStudyTour, btnHoneyMoon;
    ViewPager viewPager;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawerLayout);

        setupDrawerContent(navigationView);

        actionBarDrawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerLayout.removeDrawerListener(actionBarDrawerToggle);

        selectDrawerItem(navigationView.getMenu().getItem(0));

        // View Pager START//
        viewPager = findViewById(R.id.viewPager);

        MainAdapter mainAdapter = new MainAdapter(this);

        viewPager.setAdapter(mainAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        // View Pager END //

        btnFamily = findViewById(R.id.btnFamily);
        btnStudyTour = findViewById(R.id.btnStudyTour);
        btnHoneyMoon = findViewById(R.id.btnHoneyMoon);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavFamilyActivity.class);
                startActivity(intent);
            }
        });
        btnStudyTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavStudyTourActivity.class);
                startActivity(intent);
            }
        });
        btnHoneyMoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavHoneyMoonActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setupDrawerContent(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, getToolbar(), R.string.drawer_open, R.string.drawer_close);
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.menu_profil:
                fragment = ProfilFragment.newInstance();
                break;
            case R.id.menu_setting:
                fragment = SettingFragment.newInstance();
                break;
            default:
                fragment = ProfilFragment.newInstance();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        menuItem.setChecked(true);

        getToolbar().setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        this.finish();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Ask the user if they want to quit
        this.finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
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
