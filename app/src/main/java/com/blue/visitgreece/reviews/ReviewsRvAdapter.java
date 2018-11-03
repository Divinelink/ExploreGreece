package com.blue.visitgreece.reviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blue.visitgreece.R;

import java.util.ArrayList;

public class ReviewsRvAdapter extends RecyclerView.Adapter<ReviewsRvAdapter.ReviewsViewHolder> {

    private ArrayList<ReviewDomain> reviews;
//    private Context context; //needed for UI color bundle data , maybe not needed



    public ReviewsRvAdapter(ArrayList<ReviewDomain> reviews){
        this.reviews = reviews;
    }

//    public ReviewsRvAdapter(ArrayList<ReviewDomain> reviews,Context context){
//        this.reviews = reviews;
//        this.context = context;
//    }

    public static class ReviewsViewHolder extends RecyclerView.ViewHolder {
        TextView mReviewDescription; //or maybe name comment???
        RatingBar mRating;
        TextView mRatingNumber;
        TextView mReviewerName;
        LinearLayout mReviewItemRoot; //linear layout needs change

        public ReviewsViewHolder(View v){
            super(v);
            mReviewDescription = v.findViewById(R.id.review_description);
            mRating = (v.findViewById(R.id.review_rating));
            mRatingNumber = v.findViewById(R.id.review_rating_number);
            mReviewerName = v.findViewById(R.id.review_reviewer_name);
            mReviewItemRoot = v.findViewById(R.id.review_item_root);
        }
    }


    @NonNull
    @Override
    public ReviewsRvAdapter.ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_review_item, viewGroup, false);
        ReviewsRvAdapter.ReviewsViewHolder vh = new ReviewsRvAdapter.ReviewsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsRvAdapter.ReviewsViewHolder reviewsViewHolder, int i) {
        final int position = i;

        reviewsViewHolder.mReviewDescription.setText(reviews.get(position).getComment());
        reviewsViewHolder.mRating.setRating(reviews.get(position).getScore());
        reviewsViewHolder.mReviewerName.setText(reviews.get(position).getUsername()); //ReviewerName from User Enitity
        reviewsViewHolder.mRatingNumber.setText(String.valueOf(reviews.get(position).getScore()));//parse integer String.valueOf
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}
