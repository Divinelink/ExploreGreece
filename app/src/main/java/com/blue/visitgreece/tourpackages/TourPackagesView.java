package com.blue.visitgreece.tourpackages;

import java.util.ArrayList;

public interface TourPackagesView {
    void showTourPackages(ArrayList<TourPackageUI> tourpackages);
    void showGeneralError();
}
