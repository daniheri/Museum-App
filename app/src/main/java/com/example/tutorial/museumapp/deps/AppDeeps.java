package com.example.tutorial.museumapp.deps;

import com.example.tutorial.museumapp.base.MuseumBaseActivity;
import com.example.tutorial.museumapp.mainpage.MuseumMainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        MuseumCommonModule.class,
        MuseumConfigModule.class
})

public interface AppDeeps {
    void inject(MuseumMainActivity museumMainActivity);
}
