package com.example.tutorial.museumapp.mainpage;

import com.example.tutorial.museumapp.response.ProvinsiResponse;

import java.util.List;

public interface MuseumMainView {

    void showProgress(int visible);

    void showError(Throwable networkError);

    void setData(List<ProvinsiResponse.Datum> data);
}
