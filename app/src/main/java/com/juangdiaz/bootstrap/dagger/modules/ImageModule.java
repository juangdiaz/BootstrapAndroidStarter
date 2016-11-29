package com.juangdiaz.bootstrap.dagger.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
@Module
public class ImageModule {


    @Provides @NonNull @Singleton
    public Picasso providePicasso(@NonNull Application baseApplication, @NonNull OkHttpClient okHttpClient){
        return new Picasso.Builder(baseApplication)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }


}
