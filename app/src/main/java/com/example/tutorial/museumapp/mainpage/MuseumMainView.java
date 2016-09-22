package com.example.tutorial.museumapp.mainpage;

import com.example.tutorial.museumapp.response.ProvinsiResponse;

public interface MuseumMainView {

    void showProgress(int visible);

    void showError(Throwable networkError);

    void showData(ProvinsiResponse response);
}
