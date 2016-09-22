package com.example.tutorial.museumapp.network;

import com.example.tutorial.museumapp.config.MuseumConstant;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface MuseumNetworkService {

    @GET(MuseumConstant.api.GET_MUSEUM)
    Observable<ProvinsiResponse> getProvinsi();

}