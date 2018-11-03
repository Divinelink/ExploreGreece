package com.blue.visitgreece.rest.responses;

public class TourpackageResponse {


    private TourPackageEmbedded _embedded;

    public TourpackageResponse(TourPackageEmbedded _embedded) {
        this._embedded = _embedded;
    }

    public TourPackageEmbedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(TourPackageEmbedded _embedded) {
        this._embedded = _embedded;
    }
}
