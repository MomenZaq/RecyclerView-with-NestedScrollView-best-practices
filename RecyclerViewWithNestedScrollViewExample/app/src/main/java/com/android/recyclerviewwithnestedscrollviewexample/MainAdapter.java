package com.android.recyclerviewwithnestedscrollviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {

    List<String> items = new ArrayList<>();

    public MainAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View menuItemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_main, parent, false);
        return new OrderHolder(menuItemLayoutView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((OrderHolder) holder).textView.setText(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder {

        TextView textView;


        OrderHolder(View itemView) {
            super(itemView);


            textView = itemView.findViewById(R.id.textView);


        }


    }

}
