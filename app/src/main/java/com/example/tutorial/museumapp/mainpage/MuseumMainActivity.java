package com.example.tutorial.museumapp.mainpage;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tutorial.museumapp.MuseumApp;
import com.example.tutorial.museumapp.R;
import com.example.tutorial.museumapp.base.MuseumBaseActivity;
import com.example.tutorial.museumapp.databinding.MuseumMainActivityBinding;
import com.example.tutorial.museumapp.network.MuseumApiService;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

import java.util.List;

import javax.inject.Inject;

public class MuseumMainActivity extends MuseumBaseActivity implements MuseumMainView,MuseumMainRecycleAdapter.OnItemClickListener {

    @Inject
    MuseumApiService service;

    MuseumMainActivityBinding binding;
    MuseumMainPresenter presenter;
    @Override
    protected void setUpBinding() {
        ((MuseumApp) getApplication()).getAppDeeps().inject(this);
        binding = DataBindingUtil.setContentView(MuseumMainActivity.this, R.layout.museum_main_activity);
        presenter = new MuseumMainPresenter(service,this);
        presenter.getProvinsi();

    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        MuseumMainRecycleAdapter adapter = new MuseumMainRecycleAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        binding.listContent.setLayoutManager(mLayoutManager);
        binding.listContent.setAdapter(adapter);

    }

    @Override
    public void showProgress(int visible) {

    }

    @Override
    public void showError(Throwable networkError) {

    }

    @Override
    public void setData(List<ProvinsiResponse.Datum> data) {
        MuseumMainRecycleAdapter adapter = (MuseumMainRecycleAdapter)
                binding.listContent.getAdapter();
        adapter.add(data);
    }

    @Override
    public void onItemClick(int position) {
        MuseumMainRecycleAdapter adapter = (MuseumMainRecycleAdapter)
                binding.listContent.getAdapter();
        ProvinsiResponse.Datum datum = adapter.getData().get(position);

        Toast.makeText(MuseumMainActivity.this, datum.nama, Toast.LENGTH_SHORT).show();
    }
}
