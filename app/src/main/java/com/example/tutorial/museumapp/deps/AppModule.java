package com.example.tutorial.museumapp.deps;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context providesContext() {
        return context;
    }
}
