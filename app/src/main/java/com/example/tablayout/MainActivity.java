package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    ImageView dp;
    TextView mail;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ActionBarDrawerToggle toggle;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,new TabFragment()).commit();


        tabLayout.addTab(tabLayout.newTab().setText("Headline"));
        tabLayout.addTab(tabLayout.newTab().setText("Business"));
        tabLayout.addTab(tabLayout.newTab().setText("Health"));
        tabLayout.addTab(tabLayout.newTab().setText("Sports"));
        tabLayout.addTab(tabLayout.newTab().setText("Technology"));

         navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawer);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        getHeader();

        PagerAdapter pagerAdapter = new com.example.tablayout.pageradapter.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }




        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {

            if (menuItem.getItemId() == R.id.headline) {
                viewPager.setCurrentItem(0);
            }
            else if (menuItem.getItemId() == R.id.business) {
                viewPager.setCurrentItem(1);
            }
            else if (menuItem.getItemId() == R.id.health) {
                viewPager.setCurrentItem(2);
            }
            else if (menuItem.getItemId() == R.id.sport) {
                viewPager.setCurrentItem(3);
            }
            else if (menuItem.getItemId() == R.id.tech) {
                viewPager.setCurrentItem(4);
            }
            else{
                finish();
            }


            drawerLayout.closeDrawers();
            return false;
        }





    @Override
    public void onBackPressed () {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void getHeader(){
        NavigationView navigationView = findViewById(R.id.navigation);
        View headerview = navigationView.getHeaderView(0);
        mail = headerview.findViewById(R.id.mail);
        dp = headerview.findViewById(R.id.dp);


        Glide.with(this)
                .load(firebaseUser.getPhotoUrl())
                .into(dp);

        mail.setText(firebaseUser.getEmail());


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
