package com.example.eventplannerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

public class Supplier_Add extends AppCompatActivity {

    String [] cat = {"Garden", "Hall", "Food and Snacks", "Transport", "Drinks", "Suits", "Veils", "Chairs", "Tents", "Shoes"};
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_add);

        List<String> items = new LinkedList<>();
        items.add("Add your Category");

        RecyclerView recyclerView = findViewById(R.id.sup_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SupItemAdapter adapter = new SupItemAdapter(items);
        recyclerView.setAdapter(adapter);

        findViewById(R .id.add_btn).setOnClickListener(view ->{
            items.add(cat[counter%11]);
            counter++;
            adapter.notifyItemInserted(items.size()-1);
        });

    }
}