package com.blue.visitgreece.reviews;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class ReviewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertReviews(ArrayList<ReviewDomain> reviews);

    @Query("SELECT * FROM review")
    abstract List<ReviewDomain> getAllReviews();

    @Query("SELECT * FROM review WHERE id=:tourpackageID")
    abstract List<ReviewDomain> getAllReviewsByID(String tourpackageID);

    @Query("DELETE FROM review")
    abstract void nuke();

    @Transaction
    void updateReviews(ArrayList<ReviewDomain> reviews) {
        nuke();
        insertReviews(reviews);
    }

}
