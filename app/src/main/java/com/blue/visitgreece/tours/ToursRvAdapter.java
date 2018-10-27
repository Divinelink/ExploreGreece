package com.blue.visitgreece.tours;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blue.visitgreece.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ToursRvAdapter extends RecyclerView.Adapter<ToursRvAdapter.ToursViewHolder>{

    private ArrayList<TourUI> tours;

    private Context context;

    public ToursRvAdapter(ArrayList<TourUI> tours, Context context) {
        this.tours = tours;
        this.context = context;
    }

    public static class ToursViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mTourItemRoot;
        //ImageView mTourLogo;
        TextView mTourName;
        TextView mTourDesc;


        public ToursViewHolder(View v) {
            super(v);
            mTourItemRoot = v.findViewById(R.id.tour_item_root);
           // mTourLogo = v.findViewById(R.id.tour_logo);
            mTourName = v.findViewById(R.id.tour_name);
            mTourDesc = v.findViewById(R.id.tour_desc);
        }
    }

    @NonNull
    @Override
    public ToursViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_tour_item, viewGroup, false);
        ToursRvAdapter.ToursViewHolder vh = new ToursRvAdapter.ToursViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ToursViewHolder viewHolder, int i) {

        final int pos = i;

        viewHolder.mTourName.setText(tours.get(i).getTourName());
        //viewHolder.mTourName.setTextColor(context.getResources().getColor(tours.get(pos).getTourNameColorid()));
        viewHolder.mTourDesc.setText(tours.get(i).getTourDesc());
        //Picasso.get().load(tours.get(i).getTourLogoUrl()).into(viewHolder.mTourLogo);
    }

    @Override
    public int getItemCount() {
        return tours.size();
    }
}


