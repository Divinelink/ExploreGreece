package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tourpackages.TourPackageDomain;

import java.util.ArrayList;

public class TourpackageResponse {

    private ArrayList<TourPackageDomain> toupackages;

    public TourpackageResponse(ArrayList<TourPackageDomain> toupackages) {
        this.toupackages = toupackages;
    }

    public ArrayList<TourPackageDomain> getToupackages() {
        return toupackages;
    }

    public void setToupackages(ArrayList<TourPackageDomain> toupackages) {
        this.toupackages = toupackages;
    }
}
