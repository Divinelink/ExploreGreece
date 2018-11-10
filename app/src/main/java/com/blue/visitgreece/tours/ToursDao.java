package com.blue.visitgreece.tours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class ToursDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertTours(ArrayList<TourDomain> tours);

    @Query("SELECT * FROM tour WHERE id=:tourpackageID")
    abstract List<TourDomain> getTourByID(String tourpackageID);



    @Query("DELETE FROM tour WHERE id=:tourpackageID")
    abstract void deleteToursForTourpackageId(String tourpackageID);

    @Transaction
    void updateToursForTourpackage(ArrayList<TourDomain> tours, String tourpackageID) {
        deleteToursForTourpackageId(tourpackageID);
        insertTours(tours);
    }
    @Query("DELETE FROM tour")
    abstract void nuke();
}

