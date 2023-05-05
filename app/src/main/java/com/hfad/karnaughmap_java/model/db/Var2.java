package com.hfad.karnaughmap_java.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Var2")
public class Var2 {


    @PrimaryKey
    @NonNull
    private int id = 1;


    private int num1;
    private int num2;
    private int num3;
    private int num4;

    public void setId(int id) {
        this.id = id;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getId() {
        return id;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }

    public int getNum4() {
        return num4;
    }
}
