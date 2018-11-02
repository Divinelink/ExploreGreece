package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tourpackages.TourpackageDomain;

import java.util.ArrayList;

public class TourpackagesResponse {
    ArrayList<TourpackageDomain> tourPackages;

    public ArrayList<TourpackageDomain> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(ArrayList<TourpackageDomain> tourPackages) {
        this.tourPackages = tourPackages;
    }
}
