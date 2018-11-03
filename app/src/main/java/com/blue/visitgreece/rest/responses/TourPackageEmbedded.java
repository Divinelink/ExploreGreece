package com.blue.visitgreece.rest.responses;

class TourPackageEmbedded {
    private TourpackagesList tourPackages;

    public TourPackageEmbedded(TourpackagesList tourPackages) {
        this.tourPackages = tourPackages;
    }

    public TourpackagesList getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(TourpackagesList tourPackages) {
        this.tourPackages = tourPackages;
    }
}
