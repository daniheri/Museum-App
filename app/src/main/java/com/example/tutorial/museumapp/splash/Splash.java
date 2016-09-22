package com.example.tutorial.museumapp.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.example.tutorial.museumapp.R;
import com.example.tutorial.museumapp.base.MuseumBaseActivity;
import com.example.tutorial.museumapp.databinding.SplashScreenMuseumBinding;
import com.example.tutorial.museumapp.mainpage.MuseumMainActivity;

public class Splash extends MuseumBaseActivity implements Runnable {

    SplashScreenMuseumBinding binding;
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    
    @Override
    protected void setUpBinding() {
        binding = DataBindingUtil.setContentView(Splash.this, R.layout.splash_screen_museum);
    }

    @Override
    protected void setupPresenter() {

    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        new Handler().postDelayed(this, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void run() {
        Intent mainIntent = new Intent(Splash.this, MuseumMainActivity.class);
        Splash.this.startActivity(mainIntent);
        Splash.this.finish();
    }
}
