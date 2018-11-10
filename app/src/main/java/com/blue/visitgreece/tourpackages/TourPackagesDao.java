package com.blue.visitgreece.tourpackages;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class TourPackagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertTourpackages(ArrayList<TourPackageDomain> tourpackages);

    @Query("SELECT * FROM TourPackage")
    abstract List<TourPackageDomain> getAllTourpackages();

    @Query("SELECT * FROM TourPackage WHERE  region LIKE '%' || :region || '%'")
    abstract List<TourPackageDomain>getFilteredTourpackages(String region);

    @Query("DELETE FROM TourPackage")
    abstract void deleteAll();

    @Transaction
    void updateTourpackages(ArrayList<TourPackageDomain> tourpackages) {
        deleteAll();
        insertTourpackages(tourpackages);
    }

}
