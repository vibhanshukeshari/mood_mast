package com.vibhu.moodmastnew.Model;

import androidx.cardview.widget.CardView;

import com.google.android.material.slider.Slider;

public class ItemList {


    private String textView;
    private int imageId;

    public String getTextView() {
        return textView;
    }

    public int getImageId() {
        return imageId;
    }

    public ItemList(String textView, int imageId) {
        this.textView = textView;
        this.imageId = imageId;
    }





}
