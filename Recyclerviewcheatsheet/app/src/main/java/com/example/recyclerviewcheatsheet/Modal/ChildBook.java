package com.example.recyclerviewcheatsheet.Modal;

public class ChildBook {

    int cover_image;
    String title;
    String price;

    public ChildBook(int cover_image, String title, String price) {
        this.cover_image = cover_image;
        this.title = title;
        this.price = price;
    }

    public int getCover_image() {
        return cover_image;
    }

    public void setCover_image(int cover_image) {
        this.cover_image = cover_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
