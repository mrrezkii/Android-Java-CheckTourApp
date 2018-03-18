package id.sch.smktelkom_mlg.learn.checktourcom;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rezki on 3/16/2018.
 */

public class PrefManager {
    // shared preference file name
    private static final String PREF_NAME = "introslider";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLauch";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // share pref mode
    int PRIVATE_MODE = 0;

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLauch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
