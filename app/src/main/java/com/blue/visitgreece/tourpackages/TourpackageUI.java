package com.blue.visitgreece.tourpackages;

import android.os.Parcel;
import android.os.Parcelable;

enum Region {
    Crete("Crete"),
    Peloponnese("Peloponnese"),
    Macedonia("Macedonia"),
    Thessaly("Thessaly"),
    Thrace("Thrace"),
    Aeagean("Aeagean"),
    Ionian("Ionian"),
    StereaHellas("StereaHellas");

    private String region;

    Region(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}

public class TourpackageUI implements Parcelable {
    private String id, name, region;
    private int rating, colorId,ratingColor;

    public TourpackageUI(String id, String name, String region, int rating, int colorId, int ratingColor) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.rating = rating;
        this.colorId = colorId;
        this.ratingColor = ratingColor;
    }

    public TourpackageUI(String id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(int ratingColor) {
        this.ratingColor = ratingColor;
    }

    protected TourpackageUI(Parcel in) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TourpackageUI> CREATOR = new Parcelable.Creator<TourpackageUI>() {
        @Override
        public TourpackageUI createFromParcel(Parcel in) {
            return new TourpackageUI(in);
        }

        @Override
        public TourpackageUI[] newArray(int size) {
            return new TourpackageUI[size];
        }
    };
}