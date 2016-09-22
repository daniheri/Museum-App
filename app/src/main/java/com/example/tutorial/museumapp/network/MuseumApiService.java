package com.example.tutorial.museumapp.network;

import com.example.tutorial.museumapp.network.MuseumNetworkService;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MuseumApiService {

    MuseumNetworkService museumNetworkService;

    public MuseumApiService(MuseumNetworkService museumNetworkService) {
        this.museumNetworkService = museumNetworkService;
    }

    public Subscription getProvinsi(final ApiResponseCallback<ProvinsiResponse> callback){
        return museumNetworkService.getProvinsi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ProvinsiResponse>>() {
                    @Override
                    public Observable<? extends ProvinsiResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ProvinsiResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(ProvinsiResponse provinsiResponse) {
                        callback.onSuccess(provinsiResponse);
                    }
                });

    }

    public interface ApiResponseCallback<T> {
        void onError(Throwable networkError);

        void onSuccess(T response);

    }
}
