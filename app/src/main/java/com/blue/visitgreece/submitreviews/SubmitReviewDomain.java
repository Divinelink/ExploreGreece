package com.blue.visitgreece.submitreviews;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "submitReview")
public class SubmitReviewDomain {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idPK; //for database

    private String id;
    private int score;
    private String comment;
    private String username;

    public SubmitReviewDomain(String id, int score, String comment, String username) {
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

    @NonNull
    public int getIdPK() {
        return idPK;
    }

    public void setIdPK(@NonNull int idPK) {
        this.idPK = idPK;
    }
}
