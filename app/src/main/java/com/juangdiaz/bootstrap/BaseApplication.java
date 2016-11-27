package com.juangdiaz.bootstrap;

import android.app.Application;
import android.content.Context;

import com.juangdiaz.bootstrap.dagger.components.AppComponent;
import com.juangdiaz.bootstrap.dagger.components.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;


/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
public abstract class BaseApplication extends Application {

    public abstract void init();

    private AppComponent component;

    // Prevent need in a singleton (global) reference to the application object.
   // @NonNull
    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
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
            .build();
        //component.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return component;
    }


}




