package com.example.tablayout.StartingScreen;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tablayout.MainActivity;
import com.example.tablayout.R;
import com.roger.catloadinglibrary.CatLoadingView;

public class SplashScreen extends AppCompatActivity {

    CatLoadingView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
//        view = new CatLoadingView();
//        view.show(getSupportFragmentManager(), "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(intent);

                finish();

            }
        },3000);
    }
}
