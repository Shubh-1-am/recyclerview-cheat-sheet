package com.example.recyclerviewcheatsheet.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.R;

public class ParentViewHolder extends RecyclerView.ViewHolder {

    public TextView category_name;
    public RecyclerView nested_rv;
    public ParentViewHolder(@NonNull View itemView) {
        super(itemView);
        nested_rv = itemView.findViewById(R.id.nested_rv);
        category_name = itemView.findViewById(R.id.category_name);
    }
}
