package com.hfad.karnaughmap_java.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("Select * from var2")
    LiveData<List<Table2>> get2();

    @Query("Update var2 SET buttons = :string")
    String update2(String string);
}
