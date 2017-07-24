package com.rushro2m.movie.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/7/21.
 */

public class Api {
    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService==null){
         initApiService();
        }
        return apiService;
    }

    private static void initApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://app.vmoiver.com")
                .build();
        apiService = retrofit.create(ApiService.class);
    }
}
