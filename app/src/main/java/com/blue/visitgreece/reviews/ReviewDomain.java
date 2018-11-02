package com.blue.visitgreece.reviews;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "review")
public class ReviewDomain {


    private String id; //maybe wrong requirement? integer instead of String??
    private int score;
    private String comment;
    private String username;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idPK; //for database


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

    public int getIdPK() {
        return idPK;
    }

    public void setIdPK(int idPK) {
        this.idPK = idPK;
    }
}
