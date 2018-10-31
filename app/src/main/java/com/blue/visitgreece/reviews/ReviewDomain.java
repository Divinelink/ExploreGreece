package com.blue.visitgreece.reviews;

public class ReviewDomain {

    private String id; //maybe wrong requirement? integer instead of String??
    private int rating;
    private String ratingColor;
    private String comment;


    public ReviewDomain() {
    }

    public ReviewDomain(String id, int rating, String ratingColor, String comment) {
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
}
