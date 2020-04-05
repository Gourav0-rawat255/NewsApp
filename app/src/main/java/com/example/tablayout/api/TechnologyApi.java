package com.example.tablayout.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TechnologyApi {

    private static final String url = "http://newsapi.org/v2/";
    private static final String key ="962519c05b73447987f3e480c258f8d2";

    public static TehnologyInterface tehnologyInterface = null;

    public static TehnologyInterface technologyApi(){
        if (tehnologyInterface==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            tehnologyInterface = retrofit.create(TehnologyInterface.class);
        }

        return tehnologyInterface;


    }


}
