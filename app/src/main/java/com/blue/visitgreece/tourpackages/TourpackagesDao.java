package com.blue.visitgreece.tourpackages;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class TourpackagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertTourpackages(ArrayList<TourpackageDomain> tourpackages);

    @Query("SELECT * FROM tourpackage")
    abstract List<TourpackageDomain> getAllTourpackages();

    @Query("SELECT * FROM tourpackage WHERE region=:region")
    abstract List<TourpackageDomain>getFilteredTourpackages(String region);

    @Query("DELETE FROM tourpackage")
    abstract void deleteAll();

    @Transaction
    void updateTourpackages(ArrayList<TourpackageDomain> tourpackages) {
        deleteAll();
        insertTourpackages(tourpackages);
    }

}
