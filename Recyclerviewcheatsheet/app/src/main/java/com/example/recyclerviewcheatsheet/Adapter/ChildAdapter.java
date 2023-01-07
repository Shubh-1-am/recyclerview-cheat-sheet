package com.example.recyclerviewcheatsheet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.Modal.ChildBook;
import com.example.recyclerviewcheatsheet.R;
import com.example.recyclerviewcheatsheet.ViewHolder.ChildViewHolder;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ChildBook> childBookList;

    public ChildAdapter(Context context, List<ChildBook> childBookList) {
        this.context = context;
        this.childBookList = childBookList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nested_rv_layout,null,false);
        return new ChildViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ChildViewHolder)holder).book_cover_image.setImageResource(childBookList.get(position).getCover_image());
        ((ChildViewHolder)holder).book_title.setText(childBookList.get(position).getTitle());
        ((ChildViewHolder)holder).book_price.setText(childBookList.get(position).getPrice());

        ((ChildViewHolder)holder).book_cover_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked: "+ ((ChildViewHolder)holder).book_title.getText() , Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return childBookList.size();
    }

}
