package com.blue.visitgreece.rest.responses;

public class ToursResponse {

    private ToursResponseEmbedded _embedded;

    public ToursResponse(ToursResponseEmbedded _embedded) {
        this._embedded = _embedded;
    }
    public ToursResponseEmbedded getResult() {
        return _embedded;
    }

    public void setResult(ToursResponseEmbedded embedded) {
        _embedded = embedded;
    }
}
