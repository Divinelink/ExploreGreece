package com.blue.visitgreece.tourpackages;

import android.os.Parcel;
import android.os.Parcelable;

public class TourpackageUI implements Parcelable {
    private String tourpackageId, name, ratingColor, regionColor, imgUrl, region;
    private int rating;

    public TourpackageUI(String tourpackageId, String name, String ratingColor, String regionColor, String imgUrl, int rating, String region) {
        this.name = name;
        this.ratingColor = ratingColor;
        this.regionColor = regionColor;
        this.imgUrl = imgUrl;
        this.rating = rating;
        this.region = region;
        this.tourpackageId = tourpackageId;
    }

    public TourpackageUI(String tourpackageId, String name, String ratingColor, String regionColor, int rating, String region) {
        this.name = name;
        this.ratingColor = ratingColor;
        this.regionColor = regionColor;
        this.rating = rating;
        this.region = region;
        this.tourpackageId = tourpackageId;
    }

    public String getId() {
        return tourpackageId;
    }

    public void setId(String id) {
        this.tourpackageId = tourpackageId;
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