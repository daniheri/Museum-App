package com.example.tutorial.museumapp.mainpage;

import android.view.View;

import com.example.tutorial.museumapp.network.MuseumApiService;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

import rx.subscriptions.CompositeSubscription;

public class MuseumMainPresenter {
    private MuseumApiService service;
    private MuseumMainView view;
    CompositeSubscription compositeSubscription = null;

    public MuseumMainPresenter(MuseumApiService service, MuseumMainView view) {
        this.service = service;
        this.view = view;
        compositeSubscription = new CompositeSubscription();
    }

    void getProvinsi(){
        view.showProgress(View.VISIBLE);
        compositeSubscription.add(service.getProvinsi(new MuseumApiService.ApiResponseCallback<ProvinsiResponse>() {
            @Override
            public void onError(Throwable networkError) {
                view.showProgress(View.GONE);
                view.showError(networkError);
            }

            @Override
            public void onSuccess(ProvinsiResponse response) {
                view.showProgress(View.GONE);
                view.setData(response.data);
            }
        }));
    }

}
