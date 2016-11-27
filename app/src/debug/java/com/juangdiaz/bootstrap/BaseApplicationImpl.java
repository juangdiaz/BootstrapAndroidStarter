package com.juangdiaz.bootstrap;

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

            Timber.plant(new Timber.DebugTree(){
                //Add line number to the tag
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });

    }

}


