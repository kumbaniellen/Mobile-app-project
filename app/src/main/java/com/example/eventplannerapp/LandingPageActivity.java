package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LandingPageActivity extends AppCompatActivity {

    String[] names = {"","Customer","Supplier","Admin"};

    Spinner sp;


    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        sp = (Spinner)findViewById(R.id.spn);

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
//                        Intent intent = new Intent(getApplicationContext(), LandingPageActivity.class);
//                        startActivity(intent);
//

                        break;

                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(), Customer_signIn.class);
                        startActivity(intent2);
//                        Toast.makeText(getApplicationContext(),"you are in supplier login page", Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        Intent intent1 = new Intent(getApplicationContext(), SupplierLogin.class);
                        startActivity(intent1);
//                        Toast.makeText(getApplicationContext(),"you are in admin login page", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Admin_signIn.class));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}