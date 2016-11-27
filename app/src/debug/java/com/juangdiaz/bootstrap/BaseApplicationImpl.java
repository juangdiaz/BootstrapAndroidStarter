package com.juangdiaz.bootstrap;

import android.content.Context;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
public class BaseApplicationImpl extends BaseApplication {


    @Override
    public void init() {

        initializeStetho();
        initializeTimber();
    }


    private void initializeStetho() {
        final Context context = this;

        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(new DumperPluginsProvider() {
                            @Override
                            public Iterable<DumperPlugin> get() {

                                ArrayList<DumperPlugin> plugins = new ArrayList<>();
                                for(DumperPlugin defaultPlugin : Stetho.defaultDumperPluginsProvider(context).get()){
                                    plugins.add(defaultPlugin);
                                }
                                plugins.add(new StethoDefaultDumperPlugin());
                                return plugins;
                            }
                        })
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                        .build()
        );
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


