package com.blue.visitgreece.tourpackages;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TourpackagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTourpackages(ArrayList<TourpackageDomain> tourpackages);

    @Query("SELECT * FROM tourpackage")
    List<TourpackageDomain> getAllTourpackages();

    @Query("SELECT * FROM tourpackage WHERE region=:region")
    List<TourpackageDomain>getFilteredTourpackages(String region);

}
