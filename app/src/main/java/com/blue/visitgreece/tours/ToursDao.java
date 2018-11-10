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

    @Query("SELECT * FROM tour WHERE id=:tourPackageID")
    abstract List<TourDomain> getTourByID(String tourPackageID);


    @Query("DELETE FROM tour WHERE id=:tourPackageID")
    abstract void deleteToursForTourpackageId(String tourPackageID);

    @Transaction
    void updateToursForTourpackage(ArrayList<TourDomain> tours, String tourPackageID) {
        deleteToursForTourpackageId(tourPackageID);
        insertTours(tours);
    }
    @Query("DELETE FROM tour")
    abstract void nuke();
}

