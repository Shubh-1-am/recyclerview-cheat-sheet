package com.example.recyclerviewcheatsheet.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.R;

public class AdvertisementHolder extends RecyclerView.ViewHolder{

    public ImageView ad_image;
    public TextView ad_title;
    public TextView ad_description;
    public Button btn;
    public AdvertisementHolder(@NonNull View itemView) {
        super(itemView);
        ad_image = itemView.findViewById(R.id.ad_image);
        ad_title = itemView.findViewById(R.id.ad_title);
        ad_description = itemView.findViewById(R.id.ad_description);
        btn = itemView.findViewById(R.id.btn_learn_more);
    }
}
