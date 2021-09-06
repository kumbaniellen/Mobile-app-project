package com.example.eventplannerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class SupplierProfile extends AppCompatActivity {

    ImageView sup_prof_back_btn;
    TextView category;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_profile);

        sup_prof_back_btn = findViewById(R.id.sup_prof_back_pressed);
        category = (TextView) findViewById(R.id.categories_id);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch (item.getItemId()){
                   case R.id.profile:
                       startActivity(new Intent(getApplicationContext(),
                               S_safe_profile.class));
                       overridePendingTransition(0,0);
                       return true;

                case R.id.home:
                    startActivity(new Intent(getApplicationContext(),
                            LandingPageActivity.class));
                    overridePendingTransition(0,0);
                return true;

            case R.id.out:
            startActivity(new Intent(getApplicationContext(),
                    MainActivity.class));
            overridePendingTransition(0,0);
                       return true;
        }
                return false;
            }
        });


        sup_prof_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupplierProfile.super.onBackPressed();
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupplierProfile.this, ViewCategory.class);
                startActivity(intent);
            }
        });


    }


}