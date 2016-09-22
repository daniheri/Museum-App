package com.example.tutorial.museumapp.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProvinsiResponse {

    @SerializedName("data")
    public List<Datum> data = new ArrayList<Datum>();

    public class Datum {

        @SerializedName("kode_wilayah")
        public String kodeWilayah;

        @SerializedName("nama")
        public String nama;

        @SerializedName("mst_kode_wilayah")
        public String mstKodeWilayah;

    }
}
