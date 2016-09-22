package com.example.tutorial.museumapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MuseumBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onViewReady(savedInstanceState);
        setUpBinding();
        setupPresenter();
    }

    protected abstract void setUpBinding();

    protected abstract void setupPresenter();

    protected abstract void onViewReady(Bundle savedInstanceState);

}
