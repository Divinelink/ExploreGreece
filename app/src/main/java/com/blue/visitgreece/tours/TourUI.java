package com.blue.visitgreece.tours;

public class TourUI {

        private int id;
        private String title;
        private String description;
        private int descTextSize;


    public TourUI(int tourId, String tourName, String tourDesc, int descTextSize) {
        this.id   = tourId;
        this.title = tourName;
        this.description = tourDesc;
        this.descTextSize = descTextSize;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDescTextSize() {
        return descTextSize;
    }

    public void setDescTextSize(int descTextSize) {
        this.descTextSize = descTextSize;
    }

}


