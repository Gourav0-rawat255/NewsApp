package com.example.tablayout.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HealthApi {
    private static final String url = "http://newsapi.org/v2/";
    private static final String key ="962519c05b73447987f3e480c258f8d2";


    public static HealthInterface healthInterface= null;

    public static HealthInterface getHealthInterface(){
        if (healthInterface==null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            healthInterface = retrofit.create(HealthInterface.class);
        }
        return healthInterface;
    }


}
