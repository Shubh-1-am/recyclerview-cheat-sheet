package com.example.recyclerviewcheatsheet.Adapter;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.Modal.ChildBook;
import com.example.recyclerviewcheatsheet.Modal.OnCartImageClickListener;
import com.example.recyclerviewcheatsheet.Modal.OnWishListImageClickListener;
import com.example.recyclerviewcheatsheet.R;
import com.example.recyclerviewcheatsheet.ViewHolder.ChildViewHolder;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<ChildBook> childBookList;

    private OnWishListImageClickListener wishListImageListener;
    private OnCartImageClickListener cartImageListener;

    public ChildAdapter(Context context, List<ChildBook> childBookList) {
        this.context = context;
        this.childBookList = childBookList;
    }

    public void setWishListImageListener(OnWishListImageClickListener wishListImageListener) {
        this.wishListImageListener = wishListImageListener;
    }

    public void setCartImageListener(OnCartImageClickListener cartImageListener) {
        this.cartImageListener = cartImageListener;
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
        ((ChildViewHolder)holder).wishlist_image.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {

                if (wishListImageListener != null)
                wishListImageListener.onWishlistImageClick(holder,position);
            }
        });

        ((ChildViewHolder)holder).cart_image.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {

                if (cartImageListener != null)
                    cartImageListener.OnCartImageClick(holder,position);
            }
        });

        ((ChildViewHolder) holder).share_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,((ChildViewHolder) holder).book_title.getText().toString() + " @ ₹" +((ChildViewHolder) holder).book_price.getText().toString()+" only!");
                context.startActivity(Intent.createChooser(iShare, "Share via"));
            }
        });

    }


    @Override
    public int getItemCount() {
        return childBookList.size();
    }

}
