package com.blue.visitgreece.tourpackages;

import android.content.Context;

import com.blue.visitgreece.R;

import java.util.ArrayList;

public class TourpackagesPresenterImpl implements TourpackagesPresenter,
        TourpackagesInteractor.OnTourpackagesFinishListener {
    TourpackagesView tourpackagesView;
    TourpackagesInteractor interactor;


    public TourpackagesPresenterImpl(TourpackagesView tourpackagesView) {
        this.tourpackagesView = tourpackagesView;
        this.interactor = new TourpackagesInteractorImpl();
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
    public void onSuccess(ArrayList<TourpackageDomain> tourpackages) {

        ArrayList<TourpackageUI> tourpackagesUI = new ArrayList<>();
        if (tourpackages != null && !tourpackages.isEmpty()) {
            for (TourpackageDomain tourpackage : tourpackages) {
                TourpackageUI tourpackageUI = new TourpackageUI(tourpackage.getName(),
                                                                tourpackage.getRegion(),
                                                                tourpackage.getAverageReviewScore(),
                                                                tourpackage.getId());


                // Find By Label in Enum
                Region enumRegion = Region.valueOf(tourpackageUI.getRegion());

                switch(enumRegion){
                    case Crete:        tourpackageUI.setRegionColor(R.color.blue);
                        break;
                    case Aeagean:      tourpackageUI.setRegionColor(R.color.green);
                        break;
                    case Ionian:       tourpackageUI.setRegionColor(R.color.pink);
                        break;
                    case Thrace:       tourpackageUI.setRegionColor(R.color.colorAccent2);
                        break;
                    case Thessaly:     tourpackageUI.setRegionColor(R.color.red);
                        break;
                    case StereaHellas: tourpackageUI.setRegionColor(R.color.blue);
                        break;
                    case Peloponnese:  tourpackageUI.setRegionColor(R.color.blue);
                        break;
                    case Macedonia:    tourpackageUI.setRegionColor(R.color.blue);
                        break;
                    default:
                                       tourpackageUI.setRegionColor(R.color.blue);
                        break;
                }

                tourpackagesUI.add(tourpackageUI);
            }
        }
        tourpackagesView.showTourpackages(tourpackagesUI);
    }

    @Override
    public void onError() {
        tourpackagesView.showGeneralError();
    }

}
