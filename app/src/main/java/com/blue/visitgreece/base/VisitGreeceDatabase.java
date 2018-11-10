package com.blue.visitgreece.base;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.blue.visitgreece.reviews.ReviewDomain;
import com.blue.visitgreece.reviews.ReviewsDao;
import com.blue.visitgreece.submitreviews.SubmitReviewDomain;
import com.blue.visitgreece.submitreviews.SubmitReviewsDao;
import com.blue.visitgreece.tourpackages.TourPackageDomain;
import com.blue.visitgreece.tourpackages.TourPackagesDao;
import com.blue.visitgreece.tours.TourDomain;
import com.blue.visitgreece.tours.ToursDao;


@Database(entities = {ReviewDomain.class, TourPackageDomain.class, SubmitReviewDomain.class, TourDomain.class}, version = 5, exportSchema = false)
abstract public class VisitGreeceDatabase extends RoomDatabase {

    public abstract ReviewsDao reviewsDao();
    public abstract ToursDao toursDao();
    public abstract TourPackagesDao tourpackagesDao();
    public abstract SubmitReviewsDao submitReviewsDao();


    static private VisitGreeceDatabase INSTANCE;

    public static VisitGreeceDatabase getDatabase(Context ctx) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                    VisitGreeceDatabase.class, "visit_greece_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
