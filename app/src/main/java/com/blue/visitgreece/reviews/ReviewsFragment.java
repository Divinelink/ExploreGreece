package com.blue.visitgreece.reviews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.blue.visitgreece.R;
import com.blue.visitgreece.tours.TourUI;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsFragment extends Fragment implements ReviewsView {

    @BindView(R.id.reviews_rv)
    RecyclerView reviewsRv;


    @BindView(R.id.filter_review)
    RatingBar mRatingBar;

    ReviewsPresenter presenter;


    public ReviewsFragment() {
        // Required empty public constructor
    }

    public static ReviewsFragment newInstance(TourUI tour) {
        ReviewsFragment myFragment = new ReviewsFragment();
        Bundle args = new Bundle();
//        args.putParcelable("tour", tour); //TourUI or TourPackagesUI needs to implement parceable! to get TourPackagesID for reviews in endpoint
        myFragment.setArguments(args);
        return myFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reviews, container, false);
        ButterKnife.bind(this, v);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        reviewsRv.setLayoutManager(layoutManager);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                try
                {
                    presenter.getFilteredReviews((int)mRatingBar.getRating());//parse int to string or string?  Integer.parseInt(filterText)

                }
                catch(NumberFormatException nfe)
                {
                    presenter.getReviews(getContext());
                }

            }
        });


        presenter = new ReviewsPresenterImp(this);
        presenter.getReviews(getActivity());

        return v;

    }



    //why do we need UIThread here
    @Override
    public void showReviews(final ArrayList<ReviewDomain> reviews) {

        getActivity().runOnUiThread(new Runnable() {

            ReviewsRvAdapter adapter = new ReviewsRvAdapter(reviews);

            @Override
            public void run() {
                reviewsRv.setAdapter(adapter);
            }
        });




    }

    @Override
    public void showGeneralError() {
        Toast.makeText(getContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show();
    }



    @OnClick(R.id.filter_button)
    public void filterReviews(View view) {

        try
        {
            presenter.getFilteredReviews((int)mRatingBar.getRating());//parse int to string or string?  Integer.parseInt(filterText)

        }
        catch(NumberFormatException nfe)
        {
            presenter.getReviews(getContext());
        }


    }
}
