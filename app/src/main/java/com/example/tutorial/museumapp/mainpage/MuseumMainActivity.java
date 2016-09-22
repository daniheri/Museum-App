package com.example.tutorial.museumapp.mainpage;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tutorial.museumapp.MuseumApp;
import com.example.tutorial.museumapp.R;
import com.example.tutorial.museumapp.base.MuseumBaseActivity;
import com.example.tutorial.museumapp.databinding.MuseumMainActivityBinding;
import com.example.tutorial.museumapp.network.MuseumApiService;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

import javax.inject.Inject;

public class MuseumMainActivity extends MuseumBaseActivity implements MuseumMainView {

    @Inject
    MuseumApiService service;

    MuseumMainActivityBinding binding;
    MuseumMainPresenter presenter;
    @Override
    protected void setUpBinding() {
        ((MuseumApp) getApplicationContext()).getAppDeeps().inject(this);
        binding = DataBindingUtil.setContentView(MuseumMainActivity.this, R.layout.museum_main_activity);
        presenter.getProvinsi();
    }

    @Override
    protected void setupPresenter() {
        presenter = new MuseumMainPresenter(service,this);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }

    @Override
    public void showProgress(int visible) {

    }

    @Override
    public void showError(Throwable networkError) {

    }

    @Override
    public void showData(ProvinsiResponse response) {
        Toast.makeText(MuseumMainActivity.this, response.data.get(0).nama, Toast.LENGTH_SHORT).show();
    }
}
