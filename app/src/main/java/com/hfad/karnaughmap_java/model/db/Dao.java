package com.hfad.karnaughmap_java.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT buttons FROM Var2")
    String getButtons();

    @Query("Update Var2 SET buttons = :buttons")
    void setButtons(String buttons);
}
