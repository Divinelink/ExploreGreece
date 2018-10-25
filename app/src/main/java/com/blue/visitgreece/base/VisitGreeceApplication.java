package com.blue.visitgreece.base;

import android.app.Application;

import timber.log.Timber;

public class VisitGreeceApplication extends Application {

    public VisitGreeceApplication() {

    }


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

