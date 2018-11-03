package com.blue.visitgreece.rest.responses;

public class ToursResponseEmbedded {

    private TourResponseData tours;

    public ToursResponseEmbedded(TourResponseData tours) {
        this.tours = tours;
    }

    public TourResponseData getTours() {
        return tours;
    }

    public void setTours(TourResponseData tours) {
        this.tours = tours;
    }
}