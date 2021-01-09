package com.android.recyclerviewwithfragmenttypeexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);


        mainFragment = new MainFragment();


        //set layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //create dummy list
        List<String> items = new ArrayList<>();
        items.add("item 1");
        items.add("item 2");
        items.add("item 3");
        items.add("item 4");
        items.add("item 5");
        items.add("item 6");
        items.add("item 7");
        items.add("item 8");
        items.add("item 9");
        items.add("item 10");
        items.add("item 11");
        items.add("item 12");
        items.add("item 13");
        items.add("item 14");
        items.add("item 15");

        // add fragment type as first item to
        addFragmentTypeToRecycler(items);


        //set adapter
        MainAdapter adapter = new MainAdapter(items, new OnOpenFragmentListener() {
            @Override
            public void onOpenFragment(int viewId) {

// replace first RecyclerView item with our fragment
                try {
                    FragmentManager fragmentManager = getSupportFragmentManager();

// check if fragment is added
                    if (mainFragment.isAdded()) {
                        fragmentManager.popBackStackImmediate(MainFragment.TAG, 0);

                    } else {
                        fragmentManager.beginTransaction().
                                replace(viewId, mainFragment, MainFragment.TAG)
                                .commitAllowingStateLoss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        recyclerView.setAdapter(adapter);

    }

    private void addFragmentTypeToRecycler(List<String> items) {
        if (items.isEmpty() || items.get(0) != null) {
            items.add(0, null);

        }
    }
}