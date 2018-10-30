package com.blue.visitgreece.base;

import android.app.Application;
import android.content.Context;

import com.blue.visitgreece.R;

import org.intellij.lang.annotations.JdkConstants;

import timber.log.Timber;


public class VisitGreeceApplication extends Application {

    public VisitGreeceApplication() {

    }


    @Override
    public void onCreate() {
        super.onCreate();

        // Used to add a custom font to whole application
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                        .setDefaultFontPath("fonts/Montserrat-Medium.otf")
//                        .setFontAttrId(R.attr.fontPath)
//                        .build()
//        );
        Timber.plant(new Timber.DebugTree());

    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

