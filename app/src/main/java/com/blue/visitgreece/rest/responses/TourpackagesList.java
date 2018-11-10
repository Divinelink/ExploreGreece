package com.blue.visitgreece.rest.responses;

import com.blue.visitgreece.tourpackages.TourPackageDomain;

import java.util.ArrayList;

public class TourpackagesList {

    private ArrayList<TourPackageDomain> toupackages;

    public TourpackagesList(ArrayList<TourPackageDomain> toupackages) {
        this.toupackages = toupackages;
    }

    public ArrayList<TourPackageDomain> getToupackages() {
        return toupackages;
    }

    public void setToupackages(ArrayList<TourPackageDomain> toupackages) {
        this.toupackages = toupackages;
    }
}
