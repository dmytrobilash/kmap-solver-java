package com.hfad.karnaughmap_java.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Var2.class}, version = 2)
public abstract class KmapDatabase extends RoomDatabase {
    private static KmapDatabase INSTANCE;
    private static final String DB_NAME = "Kmap";

    public abstract Dao table2Dao();

    public static synchronized KmapDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    KmapDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
