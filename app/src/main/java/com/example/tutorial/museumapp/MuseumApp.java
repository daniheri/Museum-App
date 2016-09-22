package com.example.tutorial.museumapp;

import android.app.Application;

import com.example.tutorial.museumapp.deps.AppDeeps;
import com.example.tutorial.museumapp.deps.AppModule;
import com.example.tutorial.museumapp.deps.DaggerAppDeeps;

public class MuseumApp extends Application {

    AppDeeps deps;

    @Override
    public void onCreate() {
        super.onCreate();
        deps = DaggerAppDeeps.builder().appModule(new AppModule(this))
                .build();
    }

    public AppDeeps getAppDeeps() {
        return deps;
    }
}
