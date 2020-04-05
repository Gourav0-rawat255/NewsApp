package com.example.tablayout.api;

import com.example.tablayout.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TehnologyInterface {

    static final String key="962519c05b73447987f3e480c258f8d2" ;

    @GET("top-headlines?country=in&category=technology&apiKey="+key)
    Call<Example> getTechnologyInterface();
}
