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
    private String id, name, ratingColor, regionColor, imgUrl, region;
    private int rating;


    public TourpackageUI(String id, String name, String ratingColor, String regionColor, int rating, String region) {
        this.name = name;
        this.ratingColor = ratingColor;
        this.regionColor = regionColor;
        this.rating = rating;
        this.region = region;
        this.id = id;
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

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getRegionColor() {
        return regionColor;
    }

    public void setRegionColor(String regionColor) {
        this.regionColor = regionColor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRegion() {
        return region;
    }


    protected TourpackageUI(Parcel in) {
        rating = in.readInt();
        region = (String) in.readValue(Region.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating);
        dest.writeValue(region);
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