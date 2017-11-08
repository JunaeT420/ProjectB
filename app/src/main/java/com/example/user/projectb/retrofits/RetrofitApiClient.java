package com.example.user.projectb.retrofits;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by USER on 11/3/2017.
 */

public class RetrofitApiClient {
    private static final String BASE_URL="";
    private static Retrofit retrofit=null;
    private static Gson gson=new GsonBuilder().setLenient().create();

    public RetrofitApiClient() {
    }

    public static synchronized Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }


        return null;
    }
}
