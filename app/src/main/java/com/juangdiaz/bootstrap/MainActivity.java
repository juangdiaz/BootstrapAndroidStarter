package com.juangdiaz.bootstrap;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject SharedPreferences prefs;

   // private AppComponent appComponent;
    @BindView(R.id.title) TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BaseApplication.get(this).getApplicationComponent().inject(this);

        if(prefs != null){
            Timber.i("Prefs is not null");
        }



        Timber.d("Hello this is a debug statement using Timber");

    }
}
