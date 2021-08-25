package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupplierSignup extends AppCompatActivity {

    Button supSign_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_signup);

        supSign_btn = findViewById(R.id.supSign_btn);
        supSign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupplierSignup.this, SupplierLogin.class);
                startActivity(intent);
            }
        });
    }
}