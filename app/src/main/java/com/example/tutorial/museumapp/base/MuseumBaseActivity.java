package com.example.tutorial.museumapp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MuseumBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpBinding();
    onViewReady(savedInstanceState);
}

    protected abstract void setUpBinding();

    protected abstract void onViewReady(Bundle savedInstanceState);

}
