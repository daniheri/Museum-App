package com.example.tutorial.museumapp.mainpage;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.tutorial.museumapp.R;
import com.example.tutorial.museumapp.base.MuseumBaseActivity;
import com.example.tutorial.museumapp.databinding.MuseumMainActivityBinding;

public class MuseumMainActivity extends MuseumBaseActivity {

    MuseumMainActivityBinding binding;
    @Override
    protected void setUpBinding() {
        binding = DataBindingUtil.setContentView(MuseumMainActivity.this, R.layout.museum_main_activity);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
