package com.example.recyclerviewcheatsheet.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcheatsheet.Modal.Advertisement;
import com.example.recyclerviewcheatsheet.Modal.OnCartImageClickListener;
import com.example.recyclerviewcheatsheet.Modal.OnWishListImageClickListener;
import com.example.recyclerviewcheatsheet.Modal.ParentBook;
import com.example.recyclerviewcheatsheet.R;
import com.example.recyclerviewcheatsheet.ViewHolder.AdvertisementHolder;
import com.example.recyclerviewcheatsheet.ViewHolder.ParentViewHolder;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    ArrayList<Object> list;



    public MainAdapter(Context context, ArrayList<Object> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final RecyclerView.ViewHolder holder;
        View view;

        switch (viewType) {
            case R.layout.parent_rv_layout:
                view = LayoutInflater.from(context).inflate(R.layout.parent_rv_layout,parent,false);
                holder = new ParentViewHolder(view);
                break;
            default:
                view = LayoutInflater.from(context).inflate(R.layout.advertisement_layout,parent,false);
                holder = new AdvertisementHolder(view);
                break;
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ParentViewHolder) {
            final ParentBook parent = (ParentBook) list.get(position);
            ((ParentViewHolder)holder).category_name.setText(parent.getCategory());
            ChildAdapter childAdapter = new ChildAdapter(context,parent.getChildBookList());
            childAdapter.setWishListImageListener((OnWishListImageClickListener) context);
            childAdapter.setCartImageListener((OnCartImageClickListener) context);

            ((ParentViewHolder)holder).nested_rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            ((ParentViewHolder)holder).nested_rv.setAdapter(childAdapter);
            childAdapter.notifyDataSetChanged();

        }
        else {
            final Advertisement ad = (Advertisement) list.get(position);
            ((AdvertisementHolder)holder).ad_image.setImageResource(ad.getAdImage());
            ((AdvertisementHolder)holder).ad_title.setText(ad.getAdTitle());
            ((AdvertisementHolder)holder).ad_description.setText(ad.getAdDescription());

            ((AdvertisementHolder) holder).btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = ((AdvertisementHolder) holder).ad_title.getText().toString();
                    String url;
                    switch (title){
                        case "Spotify":
                            url = "https://open.spotify.com/";
                            break;
                        case "flipkart" :
                            url = "https://www.flipkart.com/"; break;
                        case "ProteinX":
                            url = "https://www.protinex.com/"; break;
                        default:
                            url = "https://www.google.com/";
                    }

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof ParentBook) {
            return R.layout.parent_rv_layout;
        } else if (list.get(position) instanceof Advertisement) {
            return R.layout.advertisement_layout;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
