package com.blue.visitgreece.submitreviews;

import android.os.Parcel;
import android.os.Parcelable;

public class SubmitReviewUI implements Parcelable {

    private String id;
    private int score;
    private String comment;
    private String username;

    public SubmitReviewUI(String id, int score, String comment, String username) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected SubmitReviewUI(Parcel in) {
        id = in.readString();
        score = in.readInt();
        comment = in.readString();
        username = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(score);
        dest.writeString(comment);
        dest.writeString(username);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SubmitReviewUI> CREATOR = new Parcelable.Creator<SubmitReviewUI>() {
        @Override
        public SubmitReviewUI createFromParcel(Parcel in) {
            return new SubmitReviewUI(in);
        }

        @Override
        public SubmitReviewUI[] newArray(int size) {
            return new SubmitReviewUI[size];
        }
    };
}