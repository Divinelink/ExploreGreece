package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tourpackages.TourpackageDomain;

import java.util.ArrayList;

class TourPackageResponseItem {

    public TourPackageResponseItem() {
    }

    private ArrayList<TourpackageDomain> tourPackages;

    public ArrayList<TourpackageDomain> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(ArrayList<TourpackageDomain> tourpackages) {
        tourPackages = tourpackages;
    }
}
