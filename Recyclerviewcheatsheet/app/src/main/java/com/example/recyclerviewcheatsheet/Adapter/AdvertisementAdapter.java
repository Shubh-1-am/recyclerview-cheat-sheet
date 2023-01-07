package com.example.recyclerviewcheatsheet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.Modal.Advertisement;
import com.example.recyclerviewcheatsheet.R;

import java.util.List;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.ViewHolder> {

    Context context;
    List<Advertisement> advertisementList;

    public AdvertisementAdapter(Context context, List<Advertisement> advertisementList) {
        this.context = context;
        this.advertisementList = advertisementList;
    }

    @NonNull
    @Override
    public AdvertisementAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.advertisement_layout,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertisementAdapter.ViewHolder holder, int position) {

        holder.ad_image.setImageResource(advertisementList.get(position).getAdImage());
        holder.ad_title.setText(advertisementList.get(position).getAdTitle());
        holder.ad_description.setText(advertisementList.get(position).getAdDescription());
    }

    @Override
    public int getItemCount() {
        return advertisementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ad_image;
        TextView ad_title;
        TextView ad_description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ad_image = itemView.findViewById(R.id.ad_image);
            ad_title = itemView.findViewById(R.id.ad_title);
            ad_description = itemView.findViewById(R.id.ad_description);

        }
    }
}
