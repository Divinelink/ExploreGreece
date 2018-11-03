package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tourpackages.TourpackageDomain;

import java.util.ArrayList;

class TourpackagesList {

    private ArrayList<TourpackageDomain> toupackages;

    public TourpackagesList(ArrayList<TourpackageDomain> toupackages) {
        this.toupackages = toupackages;
    }

    public ArrayList<TourpackageDomain> getToupackages() {
        return toupackages;
    }

    public void setToupackages(ArrayList<TourpackageDomain> toupackages) {
        this.toupackages = toupackages;
    }
}
