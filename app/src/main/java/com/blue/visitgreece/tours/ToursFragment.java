package com.blue.visitgreece.tours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

import com.blue.visitgreece.R;
import com.blue.visitgreece.base.HomeView;
import com.blue.visitgreece.tourpackages.TourpackageUI;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToursFragment extends Fragment implements ToursView {

    ToursPresenter presenter;

    @BindView(R.id.tourpackage_name) //bind με προηγούμενη οθόνη
            TextView mTourpackageName;

    @BindView(R.id.tourpackage_region)
            TextView mTourpackageRegion;

    @BindView(R.id.tourpackage_rating)
            TextView mTourpackageRating;

    @BindView(R.id.button_rev)
            Button mButtonRev;

    @BindView(R.id.button_all_rev)
            Button mButtonAllRev;

    @BindView(R.id.tours_rv)
            RecyclerView mToursRv;


    HomeView homeView;

    public ToursFragment() {

    }

    public static ToursFragment newInstance(TourpackageUI tourpackage, HomeView homeView) {
        ToursFragment myFragment = new ToursFragment();
        Bundle args = new Bundle();
        args.putSerializable("home_view",homeView);
        args.putParcelable("tourpackage", tourpackage);
        myFragment.setArguments(args);
        return myFragment;
    }

    TourpackageUI tourpackage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tourpackage = getArguments().getParcelable("tourpackage");
        Timber.e(tourpackage.getId()); //logging

        View v = inflater.inflate(R.layout.fragment_tours, container, false);
        ButterKnife.bind(this, v);

        homeView = (HomeView) getArguments().getSerializable("home_view");
        Timber.e(tourpackage.getRegion().toString());
        mTourpackageName.setText(tourpackage.getName());
        mTourpackageRegion.setText(tourpackage.getRegion());
        mTourpackageRating.setText(tourpackage.getRating());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mToursRv.setLayoutManager(layoutManager);

        presenter = new ToursPresenterImpl(this);
        presenter.getTours(tourpackage.getId());
        return v;

    }

    @OnClick(R.id.button_rev)
    public void OnclickReview(View v){
        homeView.addSubmitReviewFragment(tourpackage);

    }

    @OnClick(R.id.button_all_rev)
    public void OnclickAllReview(View v){
        homeView.addReviewsFragment(tourpackage);

    }

    @Override
    public void showTours(ArrayList<TourUI> tours) {
        ToursRvAdapter toursRvAdapter = new ToursRvAdapter(tours, getActivity());
        mToursRv.setAdapter(toursRvAdapter);
    }
}



