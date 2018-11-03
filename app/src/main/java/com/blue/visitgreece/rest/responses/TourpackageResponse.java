package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tourpackages.TourpackageDomain;

import java.util.ArrayList;

public class TourpackageResponse {

    private ArrayList<TourpackageDomain> toupackages;

    public TourpackageResponse(ArrayList<TourpackageDomain> toupackages) {
        this.toupackages = toupackages;
    }

    public ArrayList<TourpackageDomain> getToupackages() {
        return toupackages;
    }

    public void setToupackages(ArrayList<TourpackageDomain> toupackages) {
        this.toupackages = toupackages;
    }
}
