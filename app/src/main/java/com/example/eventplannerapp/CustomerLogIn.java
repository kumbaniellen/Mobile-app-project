package com.example.eventplannerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CustomerLogIn extends AppCompatActivity {

    ImageView cusBack_btn, cusBack2_btn ;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_log_in);

        cusBack_btn = findViewById(R.id.cusback_pressed);
        cusBack2_btn = findViewById(R.id.cusback2_pressed);
        bottomNavigationView = findViewById(R.id.bottom_cus_bar);

        cusBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerLogIn.super.onBackPressed();
            }
        });

        cusBack2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerLogIn.this, ViewCategory.class);
                startActivity(intent);
                finish();
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.exit:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cat:
                        startActivity(new Intent(getApplicationContext(),
                                ViewCategory.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:

                        return true;

                    case R.id.supplier:
                        startActivity(new Intent(getApplicationContext(),
                                SupplierList.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }
}