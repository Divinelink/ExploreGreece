package com.blue.visitgreece.tours;

public class TourDomain {
    private String TourId;
    private String TourName;
    private String TourDesc;
    private int TourDescTextSize;
    private String ImageUrl;

    public String getTourId() { return TourId; }

    public void setTourId(String tourId) {
        TourId = tourId;
    }

    public String getTourName() {
        return TourName;
    }

    public void setTourName(String tourName) {
        TourName = tourName;
    }

    public String getTourDesc() {
        return TourDesc;
    }

    public void setTourDesc(String tourDesc) {
        TourDesc = tourDesc;
    }

    public int getTourDescTextSize() {
        return TourDescTextSize;
    }

    public void setTourDescTextSize(Integer tourDescTextSize) { TourDescTextSize = tourDescTextSize; }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}

