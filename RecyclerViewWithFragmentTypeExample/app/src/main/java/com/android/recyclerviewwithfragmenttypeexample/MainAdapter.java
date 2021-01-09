package com.android.recyclerviewwithfragmenttypeexample;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {
    private static final int MENU_ITEM_VIEW_TYPE = 1;
    private static final int FRAGMENT_DETAILS_VIEW_TYPE = 2;

    private List<String> items = new ArrayList<>();
    private OnOpenFragmentListener onOpenFragmentListener;

    public MainAdapter(List<String> items, OnOpenFragmentListener onOpenFragmentListener) {
        this.items = items;
        this.onOpenFragmentListener = onOpenFragmentListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        return viewHolder based on item type
        switch (viewType) {
            case MENU_ITEM_VIEW_TYPE:
                View menuItemLayoutView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_main, parent, false);
                return new OrderHolder(menuItemLayoutView);
            case FRAGMENT_DETAILS_VIEW_TYPE:
                menuItemLayoutView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_fragment_details, parent, false);
                return new OrderHolderFragment(menuItemLayoutView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {
            case MENU_ITEM_VIEW_TYPE:
                ((OrderHolder) holder).textView.setText(items.get(position));
                break;
            case FRAGMENT_DETAILS_VIEW_TYPE:
//                check if fragment item type, call interface to handle it in MainActivity and replace current item with our fragment
                onOpenFragmentListener.onOpenFragment(((OrderHolderFragment) holder).fragmentContainer.getId());

                break;

        }

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

    @Override
    public int getItemViewType(int position) {


// return Fragment item type for first item
        if (position == 0) {
            return FRAGMENT_DETAILS_VIEW_TYPE;
        } else {
            return MENU_ITEM_VIEW_TYPE;
        }
    }

    public class OrderHolderFragment extends RecyclerView.ViewHolder {
        private ConstraintLayout fragmentContainer;

        OrderHolderFragment(View itemView) {
            super(itemView);
            try {
                fragmentContainer = (ConstraintLayout) itemView.findViewById(R.id.fragment_container_adapter);

            } catch (Exception e) {
            }
        }

    }

}
