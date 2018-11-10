package com.blue.visitgreece.tours;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

import com.blue.visitgreece.R;
import com.blue.visitgreece.base.HomeView;
import com.blue.visitgreece.tourpackages.TourPackageUI;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToursFragment extends Fragment implements ToursView {


    @BindView(R.id.tourpackage_name) //bind με προηγούμενη οθόνη
            TextView mTourpackageName;

    @BindView(R.id.tourpackage_region)
            TextView mTourpackageRegion;

    @BindView(R.id.tourpackage_rating)
         RatingBar mTourpackageRating;

    @BindView(R.id.button_rev)
            Button mButtonRev;

    @BindView(R.id.button_all_rev)
            Button mButtonAllRev;

    @BindView(R.id.tours_rv)
            RecyclerView mToursRv;
    @BindView(R.id.tours_root)
    SwipeRefreshLayout toursRoot;

    ToursPresenter presenter;
    TourPackageUI tourPackageUI;
    HomeView homeView;

    public ToursFragment() {

    }


    public static ToursFragment newInstance(TourPackageUI tourpackageUI, HomeView homeView) {

        ToursFragment myFragment = new ToursFragment();
        Bundle args = new Bundle();
        args.putSerializable("home_view",homeView);
        args.putParcelable("tourpackage", tourpackageUI);
        myFragment.setArguments(args);
        return myFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tourPackageUI = getArguments().getParcelable("tourpackage");
        Timber.e(tourPackageUI.getId()); //logging

        View v = inflater.inflate(R.layout.fragment_tours, container, false);
        ButterKnife.bind(this, v);

        toursRoot.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getTours(getActivity(), tourPackageUI, true);
            }
        });


        homeView = (HomeView) getArguments().getSerializable("home_view");

        Timber.e(tourPackageUI.getRegion().toString());
        mTourpackageName.setText(tourPackageUI.getName());
        mTourpackageRegion.setText(tourPackageUI.getRegion());
        mTourpackageRating.setRating( (float) tourPackageUI.getAverageReviewScore());


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mToursRv.setLayoutManager(layoutManager);

        presenter = new ToursPresenterImpl(this);
        presenter.getTours(getActivity(),tourPackageUI, false);
        return v;
    }


    @OnClick(R.id.button_rev)
    public void OnclickReview(View v){ homeView.addSubmitReviewFragment(tourPackageUI); }

    @OnClick(R.id.button_all_rev)
    public void OnclickAllReview(View v){
        homeView.addReviewsFragment(tourPackageUI);
    }

    @Override
    public void showTours(final ArrayList<TourUI> tours) {
        toursRoot.setRefreshing(false);

        getActivity().runOnUiThread(new Runnable() {

            ToursRvAdapter toursRvAdapter = new ToursRvAdapter(tours,getActivity());

            @Override
            public void run() {
                mToursRv.setAdapter(toursRvAdapter);
            }
        });
    }
}

