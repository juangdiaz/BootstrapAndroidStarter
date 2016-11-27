package com.juangdiaz.bootstrap;

import android.app.Application;


import timber.log.Timber;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
public class BaseApplicationImpl extends BaseApplication {


    @Override
    public void init() {
        initializeTimber();
    }

    private void initializeTimber() {

            //Release Tree
            //Crashlytics.start(); //Init Crash Reporting
            Timber.plant(new ReleaseTree());

    }


}


