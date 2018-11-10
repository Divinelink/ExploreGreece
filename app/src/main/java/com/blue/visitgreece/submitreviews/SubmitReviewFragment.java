package com.blue.visitgreece.submitreviews;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.blue.visitgreece.R;
import com.blue.visitgreece.base.HomeView;
import com.blue.visitgreece.base.VisitGreeceFragment;
import com.blue.visitgreece.login.SharedPrefManager;
import com.blue.visitgreece.tourpackages.TourPackageUI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitReviewFragment extends VisitGreeceFragment implements SubmitView, SharedPrefManager {

    TourPackageUI tourPackageUI;
    SubmitReviewPresenter presenter;

    @BindView(R.id.selected_package_textView)
    TextView mSelectedPackageTextView;
    @BindView(R.id.review_edit_text)
    EditText mReviewEditText;
    @BindView(R.id.cancel_review_button)
    Button mButtonCancelReview;
    @BindView(R.id.submit_review_button)
    Button mButtonSubmitReview;
    @BindView(R.id.review_rating)
    RatingBar mRatingBar;

    @OnClick(R.id.cancel_review_button)
    public void cancel()
    {
        getActivity().onBackPressed();
    }

    @OnClick(R.id.submit_review_button)
    public void submit() {

//TODO Add a dialog fragment with a progress while waiting to post review
        presenter.submitReview(
                tourPackageUI,
                getActivity(),
                mReviewEditText.getText().toString(),
                Math.round(mRatingBar.getRating()),
                getLastLoggedInUsername()
        );

    }

    public SubmitReviewFragment() {
        // Required empty public constructor
    }

    public static SubmitReviewFragment newInstance(TourPackageUI tourPackageUI) {
        SubmitReviewFragment myFragment = new SubmitReviewFragment();
        Bundle args = new Bundle();
        args.putParcelable("tourpackage", tourPackageUI);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_submit_review, container, false);
        ButterKnife.bind(this, v);

        tourPackageUI = getArguments().getParcelable("tourpackage");

        presenter = new SubmitReviewPresenterImpl(this);
        presenter.stylize(tourPackageUI, mSelectedPackageTextView);

        return v;
    }

    @Override
    public void showSuccessMessage() {

        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                showGeneralDialog(getResources().getString(R.string.generalSuccessDialogTitle),
                        getResources().getString(R.string.submitReviewSuccessDialogTitle),

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        },
                        getResources().getDrawable(R.drawable.ic_tag_faces_white_24dp)
                );
            }
        });

    }

    @Override
    public void showNoRatingError() {

        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                showErrorDialog(getResources().getString(R.string.noRatingDialogErrorTitle),
                        getResources().getString(R.string.noRatingDialogErrorMessage),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }
                );
            }
        });
    }

    @Override
    public void showOnError() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                showErrorDialog();
            }
        });
    }

    //FIXME is this correct?
    //FIXME You can fix this probably if you pass getLastLoggedInUsername in Fragment on newInstance
    //FIXME A better implementation would be to add user's username on the DB
    @Override
    public String getLastLoggedInUsername() {

        String username = "";

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        username = preferences.getString("username", username);

        return username;
    }
}
