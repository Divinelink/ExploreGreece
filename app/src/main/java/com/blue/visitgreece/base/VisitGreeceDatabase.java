package com.blue.visitgreece.base;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.blue.visitgreece.reviews.ReviewDomain;
import com.blue.visitgreece.reviews.ReviewsDao;
import com.blue.visitgreece.tourpackages.TourpackageDomain;
import com.blue.visitgreece.tourpackages.TourpackagesDao;
import com.blue.visitgreece.tours.TourDomain;
import com.blue.visitgreece.tours.ToursDao;

@Database(entities = {ReviewDomain.class, TourpackageDomain.class,TourDomain.class}, version = 3, exportSchema = false)
abstract public class VisitGreeceDatabase extends RoomDatabase {

    public abstract ReviewsDao reviewsDao();
    public abstract TourpackagesDao tourpackagesDao();
    public abstract ToursDao toursDao();

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
