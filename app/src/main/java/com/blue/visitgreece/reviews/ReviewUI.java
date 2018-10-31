package com.blue.visitgreece.reviews;

import android.os.Parcel;
import android.os.Parcelable;

public class ReviewUI implements Parcelable {

    private String id; //maybe wrong requirement? integer instead of String??
    private int rating;
    private String ratingColor;
    private String comment;


    public ReviewUI() {
    }

    public ReviewUI(String id, int rating, String ratingColor, String comment) {
        this.id = id;
        this.rating = rating;
        this.ratingColor = ratingColor;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    protected ReviewUI(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(comment);
        dest.writeString(ratingColor);
        dest.writeInt(rating);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    //unused
    public static final Creator<ReviewUI> CREATOR = new Creator<ReviewUI>() {
        @Override
        public ReviewUI createFromParcel(Parcel in) {
            return new ReviewUI(in);
        }

        @Override
        public ReviewUI[] newArray(int size) {
            return new ReviewUI[size];
        }
    };
}
