package com.blue.visitgreece.tourpackages;

import android.content.Context;
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
import butterknife.BindView;
import butterknife.ButterKnife;

public class TourPackageRvAdapter extends RecyclerView.Adapter<TourPackageRvAdapter.TourpackageViewHolder> {

    private ArrayList<TourPackageUI> tourpackages;
    private OnClickTourpackage listener;
    private Context context;


    public TourPackageRvAdapter(ArrayList<TourPackageUI> tourpackages, OnClickTourpackage listener, Context ctx) {
        this.tourpackages = tourpackages;
        this.listener     = listener;
        this.context      = ctx;
    }

    public static class TourpackageViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.name_tv) TextView name_tv;
        @BindView(R.id.region_tv) TextView region_tv;
        @BindView(R.id.ratingBar)RatingBar ratingBar;
        @BindView(R.id.view_tourpackage_item)RelativeLayout view_tourpackage_item;
        @BindView(R.id.ratingbar_root)LinearLayout ratinbar_layout;

        public TourpackageViewHolder(@NonNull View v) {
            super(v);
            ButterKnife.bind(this,v);
        }
    }

    @NonNull
    @Override
    public TourpackageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_tourspackage_item, viewGroup, false);

        TourpackageViewHolder vh = new TourpackageViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TourpackageViewHolder viewHolder, int i) {
        final int pos = i;
        viewHolder.name_tv.setTextColor(context.getResources().getColor(tourpackages.get(pos).getRegionColor()));
        viewHolder.name_tv.setText(tourpackages.get(pos).getName());
        viewHolder.region_tv.setText(tourpackages.get(pos).getRegion().toString());
        viewHolder.ratingBar.setRating((float) tourpackages.get(pos).getAverageReviewScore());

        viewHolder.view_tourpackage_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Listener
                listener.onTourPackageClicked(tourpackages.get(pos));
            }
        });

        viewHolder.ratinbar_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRateChangeClicked(tourpackages.get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tourpackages.size();
    }
}
