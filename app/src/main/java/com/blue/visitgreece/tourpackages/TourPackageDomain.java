package com.blue.visitgreece.tourpackages;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "TourPackage")
public class TourPackageDomain {

    @PrimaryKey
    @NonNull
    private String id;

    private String name,region;
    private double averageReviewScore;

    public TourPackageDomain(String name, String region, double averageReviewScore, String id) {
        this.name = name;
        this.region = region;
        this.averageReviewScore = averageReviewScore;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getAverageReviewScore() {
        return averageReviewScore;
    }

    public void setAverageReviewScore(double averageReviewScore) {
        this.averageReviewScore = averageReviewScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
