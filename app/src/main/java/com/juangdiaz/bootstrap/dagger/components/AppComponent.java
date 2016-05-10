package com.juangdiaz.bootstrap.dagger.components;

import com.juangdiaz.bootstrap.BaseApplication;
import com.juangdiaz.bootstrap.MainActivity;
import com.juangdiaz.bootstrap.dagger.modules.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author juandiaz <juandiaz@us.univision.com> Android Developer
 *         Copyright (C) 2016, Univision Communications Inc.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {
    void inject(BaseApplication baseApplication);
    void inject(MainActivity activity);
}
