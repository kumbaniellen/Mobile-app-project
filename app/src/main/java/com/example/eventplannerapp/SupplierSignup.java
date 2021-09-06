package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SupplierSignup extends AppCompatActivity {
    EditText sup_fullName, sup_email, sup_contact, sup_password, sup_confirmPass;
    DbHelper db;

    Button supSign_btn;
    ImageView sup_signup_back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_signup);

        sup_fullName = findViewById(R.id.edt_login_username);
        sup_email = findViewById(R.id.edt_mail);
        sup_contact = findViewById(R.id.edt_contact);
        sup_password = findViewById(R.id.edt_signup_Password);
        sup_confirmPass = findViewById(R.id.edt_signup_confirmPassword);
        supSign_btn = findViewById(R.id.supSign_btn);
        sup_signup_back_pressed = findViewById(R.id.sup_signup_back_pressed);

        sup_signup_back_pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupplierSignup.super.onBackPressed();
            }
        });

        db = new DbHelper(this);

        supSign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sfullName = sup_fullName.getText().toString();
                String semail = sup_email.getText().toString();
                String scontact = sup_contact.getText().toString();
                String spassword = sup_password.getText().toString();
                String sconfirmpass = sup_confirmPass.getText().toString();

                if (sfullName.isEmpty() || semail.isEmpty() || scontact.isEmpty() || spassword.isEmpty() || sconfirmpass.isEmpty()) {
                    Toast.makeText(SupplierSignup.this, "Complete the form first", Toast.LENGTH_SHORT).show();
                } else {
                    if (spassword.equals(sconfirmpass)) {
                        Boolean checkmail = db.checkMail(semail);
                        if (checkmail == true) {
                            Boolean insert = db.insertSupplier(sfullName, semail, scontact, spassword);
                            if (insert == true) {
                                Toast.makeText(SupplierSignup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SupplierSignup.this, SupplierLogin.class);
                                startActivity(intent);

                            }
                        } else {
                            Toast.makeText(SupplierSignup.this, "Already exist", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(SupplierSignup.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}

