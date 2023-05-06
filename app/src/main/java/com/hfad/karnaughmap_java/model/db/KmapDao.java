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
    void insertVar2(Var2 var2);

    @Update
    void updateVar2(Var2 var2);

    @Query("SELECT * FROM var2 WHERE id = 1")
    LiveData<Var2> getButtonsVar2();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertVar3(Var3 var3);

    @Update
    void updateVar3(Var3 var3);

    @Query("SELECT * FROM var3 WHERE id = 1")
    LiveData<Var3> getButtonsVar3();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertVar4(Var4 var4);

    @Update
    void updateVar4(Var4 var4);

    @Query("SELECT * FROM var4 WHERE id = 1")
    LiveData<Var4> getButtonsVar4();
}