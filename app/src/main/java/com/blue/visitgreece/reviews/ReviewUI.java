package com.blue.visitgreece.reviews;

import android.os.Parcel;
import android.os.Parcelable;

public class ReviewUI implements Parcelable {

    private String id; //maybe wrong requirement? integer instead of String??
    private int score;
    private String comment;
    private String username;
    private int ratingColorID;


    public ReviewUI() {
    }

    public ReviewUI(String id, int score, String comment, String username) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRatingColorID() {
        return ratingColorID;
    }

    public void setRatingColorID(int ratingColorID) {
        this.ratingColorID = ratingColorID;
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
        dest.writeInt(ratingColorID);
        dest.writeInt(score);


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
