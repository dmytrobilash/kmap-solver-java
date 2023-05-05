package com.hfad.karnaughmap_java.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface KmapDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Var2 var2);

    @Update
    void update(Var2 var2);

    @Query("SELECT * FROM var2 WHERE id = 1")
    LiveData<Var2> getMyData();
}