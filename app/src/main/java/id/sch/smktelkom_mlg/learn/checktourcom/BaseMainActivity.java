package id.sch.smktelkom_mlg.learn.checktourcom;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Rezki on 4/28/2018.
 */

public class BaseMainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        toolbar = findViewById(R.id.toolbar);
        setupToolbar();
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

}
