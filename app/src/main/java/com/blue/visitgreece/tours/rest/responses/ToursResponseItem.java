package com.blue.visitgreece.tours.rest.responses;

import com.blue.visitgreece.tours.TourDomain;

import java.util.ArrayList;

public class ToursResponseItem {

    private ArrayList<TourDomain> Items;

    public ArrayList<TourDomain> getItems() {
        return Items;
    }
    public void setItems(ArrayList<TourDomain> items) {
        Items = items;
    }

}