package com.juangdiaz.bootstrap;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.juangdiaz.bootstrap.dagger.components.AppComponent;
import com.juangdiaz.bootstrap.dagger.components.DaggerAppComponent;
import com.juangdiaz.bootstrap.dagger.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;


/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
public abstract class BaseApplication extends Application {

    public abstract void init();

    private AppComponent component;

    // Prevent need in a singleton (global) reference to the application object.
    @NonNull
    public static BaseApplication get(Context context) {
        return (BaseApplicationImpl) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();

        LeakCanary.install(this);
        initializeInjector();
    }




    private void initializeInjector() {
        component = DaggerAppComponent.builder()
                        .applicationModule(new ApplicationModule(this))
                        .build();
        component.inject((BaseApplicationImpl) this);
    }

    public AppComponent getApplicationComponent() {
        return component;
    }


}




