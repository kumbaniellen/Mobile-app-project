package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Customer_signIn extends AppCompatActivity {

   Button custom_btn;
   TextView cusSignup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_in);

        custom_btn =  findViewById(R.id.custom_btn);
        cusSignup_btn = findViewById(R.id.cusSignup_btn);

        custom_btn.setOnClickListener(v -> {
            Intent intent= new Intent(Customer_signIn.this, ViewCategory.class);
            startActivity(intent);
        });

        cusSignup_btn.setOnClickListener(v -> {
            Intent m= new Intent(Customer_signIn.this, CustomerSignUp.class);
            startActivity(m);
        });
    }
}