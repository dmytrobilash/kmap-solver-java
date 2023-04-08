package com.hfad.karnaughmap_java.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Table2.class}, version = 1)
abstract class KmapDatabase extends RoomDatabase {

    public abstract Dao table2Dao();

    private static volatile KmapDatabase INSTANCE;

    public static KmapDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (KmapDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            KmapDatabase.class,
                            "my_app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
