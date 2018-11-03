package com.blue.visitgreece.tourpackages;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.blue.visitgreece.R;
import com.blue.visitgreece.base.HomeView;
import com.blue.visitgreece.login.LoginFragment;
import com.blue.visitgreece.login.LoginUI;
import com.blue.visitgreece.tours.ToursFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class TourspackagesFragment extends Fragment implements TourpackagesView {

    @BindView(R.id.tourspackage_Rv)
    RecyclerView tourspackage_rv;
    @BindView(R.id.filter_ed)
    EditText filter_ed;

    TourpackagesPresenter presenter;
    HomeView homeView;

    public TourspackagesFragment() {
        // Required empty public constructor
    }

    // Den kserw an einai swstos tropos erwtisi ston petro.
    public static TourspackagesFragment newInstance(HomeView homeView) {
        Bundle args = new Bundle();
        TourspackagesFragment fragment = new TourspackagesFragment();

        args.putSerializable("homeView", homeView);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new TourpackagesPresenterImpl(this);
        presenter.getTourpackages(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tourspackages, container, false);
        ButterKnife.bind(this, v);

        // Get arguments from bundle
        homeView = (HomeView) getArguments().getSerializable("homeView");



        // Set up Layoutmanager in Recycler View
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        tourspackage_rv.setLayoutManager(layoutManager);


        return v;
    }

    @Override
    public void showTourpackages(final ArrayList<TourpackageUI> tourpackages) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                TourpacakgeRvAdapter tourpackagesRvAdapter = new TourpacakgeRvAdapter(tourpackages, new OnClickTourpackage() {
                    @Override
                    public void onTourpackageClikced(TourpackageUI tourpackage) {
                        // Pass id to another screen
                        Timber.d("TourPackage Clicked");
                        Timber.e(tourpackage.getRegion());
                        //homeView.addToursFragment(tourpackage);
                    }

                    @Override
                    public void onRateChangeCllicked(TourpackageUI tourpackage) {
                        // GO to the review submit screen
                        Timber.d("Rate Clicked");
                    }
                }, getActivity());

                @Override
                public void run() {
                    Timber.e("ADAPTER SETED");
                    tourspackage_rv.setAdapter(tourpackagesRvAdapter);
                }
            });
        }

    }

    @Override
    public void showGeneralError() {

    }

    @OnClick(R.id.filter_btn)
    public void getFilterTourPacakages(View v) {
        String filteredText = filter_ed.getText().toString();
        presenter.getFilteredTourPackages(filteredText);
    }

}
