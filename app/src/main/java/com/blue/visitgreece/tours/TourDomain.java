package com.blue.visitgreece.tours;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.blue.visitgreece.tourpackages.TourPackageDomain;

@Entity(tableName = "tour")
public class TourDomain {

    @PrimaryKey
    @NonNull
    private String id;
    private String title;
    private String description;
    private String tourpackageId;


    public TourDomain() {

    }

    public TourDomain(String Id, String Title, String Description) {
        id = Id;
        title = Title;
        description = Description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTourpackageId() {
        return tourpackageId;
    }

    public void setTourpackageId(String tourpackageId) {
        this.tourpackageId = tourpackageId;
    }

}