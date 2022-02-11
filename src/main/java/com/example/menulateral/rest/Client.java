package com.example.menulateral.rest;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Retrofit retrofit = null;
    private Client(){}

    public static Retrofit getClient(String url){
        if(retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    //.addConverterFactory(JacksonConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}