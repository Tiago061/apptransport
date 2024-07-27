package com.example.projetoestagioaiko;

import com.example.projetoestagioaiko.OlhoVivoApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRetrofit {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.olhovivo.sptrans.com.br/v2.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    OlhoVivoApiService apiService = retrofit.create(OlhoVivoApiService.class);

}
