package com.example.tutorial.museumapp.config;


public class MuseumConfig {

    private String baseUrl;

    public MuseumConfig(String baseUrl){
        this.setBaseUrl(baseUrl);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
