package com.blue.visitgreece.reviews;

public class ReviewDomain {

    private String id; //maybe wrong requirement? integer instead of String??
    private int score;
    private String comment;
    private String username;


    public ReviewDomain() {
    }

    public ReviewDomain(String id, int rating, String comment, String username) {
        this.id = id;
        this.score = rating;
        this.comment = comment;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
}
