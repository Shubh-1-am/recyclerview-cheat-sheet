package com.example.recyclerviewcheatsheet.Modal;

public class Advertisement {

    int adImage;
    String adTitle;
    String adDescription;

    public Advertisement(int adImage, String adTitle, String adDescription) {
        this.adImage = adImage;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    public int getAdImage() {
        return adImage;
    }

    public void setAdImage(int adImage) {
        this.adImage = adImage;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdDescription() {
        return adDescription;
    }

    public void setAdDescription(String adDescription) {
        this.adDescription = adDescription;
    }
}
