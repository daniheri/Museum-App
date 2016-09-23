package com.example.tutorial.museumapp.mainpage;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

public class MuseumRecylerViewModel extends BaseObservable {

    private ProvinsiResponse.Datum datum;

    public MuseumRecylerViewModel(ProvinsiResponse.Datum datum) {
        this.datum = datum;
        notifyProperties();
    }

    private void notifyProperties() {
        notifyPropertyChanged(BR.provinsi);
    }

    @Bindable
    public String getProvinsi() {
        return datum.nama;
    }
}
