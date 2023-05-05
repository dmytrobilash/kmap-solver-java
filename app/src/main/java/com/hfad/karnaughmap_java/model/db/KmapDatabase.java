package com.hfad.karnaughmap_java.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Var2.class}, version = 1, exportSchema = false)
public abstract class KmapDatabase extends RoomDatabase {
    private static KmapDatabase instance;

    public abstract KmapDao myDataDao();

    public static synchronized KmapDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    KmapDatabase.class, "my_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}