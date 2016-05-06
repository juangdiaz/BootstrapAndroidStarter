package com.juangdiaz.bootstrap;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author juandiaz <juandiaz@us.univision.com> Android Developer
 *         Copyright (C) 2016, Univision Communications Inc.
 */
public class BaseApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
