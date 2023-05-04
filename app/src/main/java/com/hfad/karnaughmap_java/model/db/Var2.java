package com.hfad.karnaughmap_java.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Var2")
public class Var2 {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "buttons")
    private String buttons = "0001";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getButtons() {
        return buttons;
    }

    public void setButtons(String buttons) {
        this.buttons = buttons;
    }
}

