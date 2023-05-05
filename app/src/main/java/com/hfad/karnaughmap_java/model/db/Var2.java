package com.hfad.karnaughmap_java.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Var2")
public class Var2 {
    @PrimaryKey
    @NonNull
    private int id = 1;

    private String btn0 = "0";
    private String btn1 = "0";
    private String btn2 = "0";
    private String btn3 = "0";

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBtn0() {
        return btn0;
    }

    public void setBtn0(String btn0) {
        this.btn0 = btn0;
    }

    public String getBtn1() {
        return btn1;
    }

    public void setBtn1(String btn1) {
        this.btn1 = btn1;
    }

    public String getBtn2() {
        return btn2;
    }

    public void setBtn2(String btn2) {
        this.btn2 = btn2;
    }

    public String getBtn3() {
        return btn3;
    }

    public void setBtn3(String btn3) {
        this.btn3 = btn3;
    }
}
