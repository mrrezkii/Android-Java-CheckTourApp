package id.sch.smktelkom_mlg.learn.checktourcom.Fonts;

import android.app.Application;

import id.sch.smktelkom_mlg.learn.checktourcom.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Rezki on 3/16/2018.
 */

public class ImageSlider extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/PoetsenOne-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
