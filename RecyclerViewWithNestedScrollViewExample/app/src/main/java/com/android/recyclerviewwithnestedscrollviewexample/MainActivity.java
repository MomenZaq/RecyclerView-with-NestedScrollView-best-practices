package com.android.recyclerviewwithnestedscrollviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);



        //set layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


//        make smooth scroll
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);


        //create dummy list
        List<String> items = new ArrayList<>();
        items.add("item 1");
        items.add("item 2");
        items.add("item 3");
        items.add("item 4");
        items.add("item 5");


        //set adapter
        MainAdapter adapter = new MainAdapter(items);
        recyclerView.setAdapter(adapter);

    }
}