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

public class TourPackageUI implements Parcelable {
    private String name,region;
    private double averageReviewScore;
    private int rating, regionColor,ratingColor;
    private String id;

    public TourPackageUI(String name, String region, double averageReviewScore, String id) {
        this.name = name;
        this.region = region;
        this.averageReviewScore = averageReviewScore;
        this.id = id;
    }

    public TourPackageUI(String name, String region, double averageReviewScore, int rating, int regionColor, int ratingColor, String id) {
        this.name = name;
        this.region = region;
        this.averageReviewScore = averageReviewScore;
        this.rating = rating;
        this.regionColor = regionColor;
        this.ratingColor = ratingColor;
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

    public double getAverageReviewScore() {
        return averageReviewScore;
    }

    public void setAverageReviewScore(double averageReviewScore) {
        this.averageReviewScore = averageReviewScore;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRegionColor() {
        return regionColor;
    }

    public void setRegionColor(int regionColor) {
        this.regionColor = regionColor;
    }

    public int getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(int ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected TourPackageUI(Parcel in) {
        region = in.readString();
        averageReviewScore = in.readDouble();
        id = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(region);
        dest.writeDouble(averageReviewScore);
        dest.writeString(id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TourPackageUI> CREATOR = new Parcelable.Creator<TourPackageUI>() {
        @Override
        public TourPackageUI createFromParcel(Parcel in) {
            return new TourPackageUI(in);
        }

        @Override
        public TourPackageUI[] newArray(int size) {
            return new TourPackageUI[size];
        }
    };
}