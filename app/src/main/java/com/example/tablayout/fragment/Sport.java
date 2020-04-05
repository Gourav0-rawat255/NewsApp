package com.example.tablayout.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tablayout.R;
import com.example.tablayout.api.SportInterface;
import com.example.tablayout.api.SportApi;
import com.example.tablayout.model.Article;
import com.example.tablayout.model.Example;
import com.example.tablayout.pageradapter.NewsAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Sport extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Article> articleList;
    NewsAdapter adapter;

    TextView textView;

    public Sport() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        getData();


    }

    public void getData() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportInterface sportInterface = retrofit.create(SportInterface.class);

        Call<Example> exampleCall = SportApi.getSportApi().getSportInterface();
        exampleCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                articleList= new ArrayList<>(Arrays.asList(example.getArticles()));
                adapter = new NewsAdapter(articleList,getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {


                Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });




    }
}


