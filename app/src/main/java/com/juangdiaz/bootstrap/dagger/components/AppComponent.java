package com.juangdiaz.bootstrap.dagger.components;

import com.juangdiaz.bootstrap.BaseApplicationImpl;
import com.juangdiaz.bootstrap.MainActivity;
import com.juangdiaz.bootstrap.dagger.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
@Singleton
@Component(modules = {
        ApplicationModule.class })//, add later
        //NetworkModule.class,
        //ApiModule.class,
        //ImageModule.class
        // })
public interface AppComponent {
    void inject(BaseApplicationImpl baseApplication);
    void inject(MainActivity activity);
}
