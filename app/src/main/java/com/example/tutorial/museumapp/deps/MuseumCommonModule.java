package com.example.tutorial.museumapp.deps;

import com.example.tutorial.museumapp.config.MuseumConfig;
import com.example.tutorial.museumapp.network.MuseumApiService;
import com.example.tutorial.museumapp.network.MuseumNetworkService;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MuseumCommonModule {

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public MuseumNetworkService providesMuseumService(
            Gson gson,
            OkHttpClient okHttpClient,
            MuseumConfig config) {

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(config.getBaseUrl() + "/")
                .build();

        return retrofit.create(MuseumNetworkService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public MuseumApiService providesMassageApiService(MuseumNetworkService massageService) {
        return new MuseumApiService(massageService);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public OkHttpClient providesHttp() {
        return new OkHttpClient();
    }

}
