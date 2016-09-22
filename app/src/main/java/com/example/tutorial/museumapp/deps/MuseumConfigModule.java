package com.example.tutorial.museumapp.deps;

import android.content.Context;

import com.example.tutorial.museumapp.R;
import com.example.tutorial.museumapp.config.MuseumConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MuseumConfigModule {

    private final String baseUrl;

    public MuseumConfigModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public MuseumConfig providesGoLifeConfig(Context context){
        String lifeUrl = baseUrl != null ? baseUrl : context.getString(R.string.museum_url);
        return new MuseumConfig(lifeUrl);
    }

}
