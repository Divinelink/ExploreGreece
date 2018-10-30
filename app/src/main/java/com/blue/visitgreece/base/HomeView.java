package com.blue.visitgreece.base;

import com.blue.visitgreece.tourpackages.TourpackageUI;

import java.io.Serializable;

public interface HomeView extends Serializable{
    void addToursFragment(TourpackageUI tourpackageUI);
}
