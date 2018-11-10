package com.blue.visitgreece.tourpackages;

import android.content.Context;

import com.blue.visitgreece.R;

import java.util.ArrayList;

public class TourPackagesPresenterImpl implements TourPackagesPresenter,
        TourPackagesInteractor.OnTourpackagesFinishListener {
    TourPackagesView tourPackagesView;
    TourPackagesInteractor interactor;


    public TourPackagesPresenterImpl(TourPackagesView tourPackagesView) {
        this.tourPackagesView = tourPackagesView;
        this.interactor = new TourPackagesInteractorImpl();
    }

    @Override
    public void getTourpackages(Context ctx, boolean refresh) {
        interactor.getTourpackages(this, ctx, refresh);
    }

    @Override
    public void getFilteredTourPackages(String filter, Context ctx) {
        // Ερωτηση : Γιατι περναέι και τον Listener Μέσα;;;
        interactor.getFilteredTourpackages(this, filter, ctx);
    }

    @Override
    public void onSuccess(ArrayList<TourPackageDomain> tourpackages) {

        ArrayList<TourPackageUI> tourpackagesUI = new ArrayList<>();
        if (tourpackages != null && !tourpackages.isEmpty()) {
            for (TourPackageDomain tourpackage : tourpackages) {
                TourPackageUI tourPackageUI = new TourPackageUI(tourpackage.getName(),
                                                                tourpackage.getRegion(),
                                                                tourpackage.getAverageReviewScore(),
                                                                tourpackage.getId());


                // Find By Label in Enum
                Region enumRegion = Region.valueOf(tourPackageUI.getRegion());

                switch(enumRegion){
                    case Crete:        tourPackageUI.setRegionColor(R.color.blue);
                    break;
                    case Aeagean:      tourPackageUI.setRegionColor(R.color.green);
                        break;
                    case Ionian:       tourPackageUI.setRegionColor(R.color.pink);
                        break;
                    case Thrace:       tourPackageUI.setRegionColor(R.color.colorAccent2);
                        break;
                    case Thessaly:     tourPackageUI.setRegionColor(R.color.red);
                        break;
                    case StereaHellas: tourPackageUI.setRegionColor(R.color.blue);
                        break;
                    case Peloponnese:  tourPackageUI.setRegionColor(R.color.blue);
                        break;
                    case Macedonia:    tourPackageUI.setRegionColor(R.color.blue);
                        break;
                    default:
                                       tourPackageUI.setRegionColor(R.color.blue);
                        break;
                }

                tourpackagesUI.add(tourPackageUI);
            }
        }
        tourPackagesView.showTourPackages(tourpackagesUI);
    }

    @Override
    public void onError() {
        tourPackagesView.showGeneralError();
    }

}
