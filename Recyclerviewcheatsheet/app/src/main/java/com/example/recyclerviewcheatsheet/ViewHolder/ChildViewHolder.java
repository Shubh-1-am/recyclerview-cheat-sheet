package com.example.recyclerviewcheatsheet.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.R;

public class ChildViewHolder extends RecyclerView.ViewHolder {

    public ImageView book_cover_image;
    public TextView book_title;
    public TextView book_price;
    public ImageView cart_image;
    public ImageView wishlist_image;
    public ImageView share_image;

    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
        book_cover_image = itemView.findViewById(R.id.book_cover_image);
        book_title = itemView.findViewById(R.id.book_title);
        book_price = itemView.findViewById(R.id.book_price);
        cart_image = itemView.findViewById(R.id.add_to_cart_image);
        wishlist_image = itemView.findViewById(R.id.add_to_wishlist_image);
        share_image = itemView.findViewById(R.id.share_image);

    }
}
