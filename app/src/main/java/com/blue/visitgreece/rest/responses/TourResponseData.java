package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tours.TourDomain;

import java.util.ArrayList;

public class TourResponseData {

    private ArrayList<TourDomain> tours;

    public ArrayList<TourDomain> getData() {
        return tours;
    }

    public void setData(ArrayList<TourDomain> tours) {
        this.tours = tours;
    }

    public TourResponseData(ArrayList<TourDomain> tours) {
        this.tours = tours;
    }



}
