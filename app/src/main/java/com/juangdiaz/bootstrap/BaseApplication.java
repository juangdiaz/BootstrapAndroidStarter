package com.juangdiaz.bootstrap;

import android.app.Application;
import android.content.Context;

import com.juangdiaz.bootstrap.dagger.components.AppComponent;
import com.juangdiaz.bootstrap.dagger.components.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * @author juandiaz <juandiaz@us.univision.com> Android Developer
 *         Copyright (C) 2016, Univision Communications Inc.
 */
public class BaseApplication extends Application {


    private AppComponent component;

    // Prevent need in a singleton (global) reference to the application object.
   // @NonNull
    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);

        initializeInjector();

        initializeTimber();
    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeInjector() {
        component = DaggerAppComponent.builder()
            .build();
        component.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return component;
    }
}


