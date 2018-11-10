package com.blue.visitgreece.submitreviews;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.blue.visitgreece.reviews.ReviewDomain;

@Dao
public abstract class SubmitReviewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void submitReviewToDB(ReviewDomain review);

    @Query("DELETE FROM submitReview WHERE username = :username")
    abstract void deleteByUsername(String username);



}
