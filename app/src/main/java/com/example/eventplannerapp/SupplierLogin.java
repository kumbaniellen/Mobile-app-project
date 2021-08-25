package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SupplierLogin extends AppCompatActivity {

    Button supplier_btn;
    TextView supplier_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_login);

        supplier_btn = (Button) findViewById(R.id.supplier_btn);
        supplier_sign_up = (TextView) findViewById(R.id.supplier_sign_up);

        supplier_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(SupplierLogin.this, SupplierProfile.class);
                    startActivity(s);


            }
        });
        supplier_sign_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent m = new Intent(SupplierLogin.this, SupplierSignup.class);
                startActivity(m);
            }
        });
    }
}