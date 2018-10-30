package com.blue.visitgreece.tourpackages;


enum Region{
    Crete, Pelloponese, Macedonia, Thessaly, Thrace, Aegean, Ionian, StereaHellas;


}

public class TourpackageDomain {

    private String tourpackageId, name, ratingColor, regionColor, imgUrl, region;
    private int rating;


    public TourpackageDomain(String tourpackageId, String name, String ratingColor, String regionColor, int rating, String region) {
        this.tourpackageId = tourpackageId;
        this.name = name;
        this.ratingColor = ratingColor;
        this.regionColor = regionColor;
        this.rating = rating;
        this.region = region;
    }

    public TourpackageDomain(String tourpackageId, String name, String ratingColor, String regionColor, String imgUrl, int rating, String region) {
        this.tourpackageId = tourpackageId;
        this.name = name;
        this.ratingColor = ratingColor;
        this.regionColor = regionColor;
        this.imgUrl = imgUrl;
        this.rating = rating;
        this.region = region;
    }

    public String getId() {
        return tourpackageId;
    }

    public void setId(String id) {
        this.tourpackageId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getRegionColor() {
        return regionColor;
    }

    public void setRegionColor(String regionColor) {
        this.regionColor = regionColor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRegion() {
        return region;
    }
}
