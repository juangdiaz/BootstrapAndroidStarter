package com.juangdiaz.bootstrap.dagger.modules;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juangdiaz.bootstrap.BuildConfig;
import com.juangdiaz.bootstrap.api.RestApiCall;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author juandiaz <juandiaz@us.univision.com> Android Developer
 *         Copyright (C) 2016, Univision Communications Inc.
 */

@Module
public class ApiModule {

    @Provides
    @NonNull @Singleton
    public RestApiCall restApiCall(@NonNull OkHttpClient okHttpClient, @NonNull ObjectMapper objectMapper) {
        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .client(okHttpClient)
                .validateEagerly(BuildConfig.DEBUG)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        return builder.build().create(RestApiCall.class);
    }
}
