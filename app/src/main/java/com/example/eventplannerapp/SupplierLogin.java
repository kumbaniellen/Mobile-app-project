package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SupplierLogin extends AppCompatActivity {

    DbHelper dbHelper;
    Button supplier_btn;
    TextView supplier_sign_up;
    EditText loginEmail,loginPassword;
    ImageView supback_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_login);

        supplier_btn = (Button) findViewById(R.id.supplier_btn);
        supplier_sign_up = (TextView) findViewById(R.id.supplier_sign_up);
        loginEmail = findViewById(R.id.edt_login_email);
        loginPassword = findViewById(R.id.edt_login_password);
        dbHelper = new DbHelper(this);
        supback_btn = findViewById(R.id.supback_pressed);

        supback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupplierLogin.super.onBackPressed();
            }
        });

        supplier_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                Boolean checkmailpassword = dbHelper.checkEmailPass(email,password);


                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SupplierLogin.this, "Complete the fields", Toast.LENGTH_SHORT).show();
                }else  if (checkmailpassword == true){
                    Intent s = new Intent(SupplierLogin.this, SupplierProfile.class);
                    startActivity(s);
                }else
                    Toast.makeText(SupplierLogin.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();


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