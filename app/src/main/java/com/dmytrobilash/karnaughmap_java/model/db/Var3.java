package com.dmytrobilash.karnaughmap_java.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Var3")
public class Var3 {
    @PrimaryKey
    @NonNull
    private int id = 1;

    private String btn0 = "0";
    private String btn1 = "0";
    private String btn2 = "0";
    private String btn3 = "0";
    private String btn4 = "0";
    private String btn5 = "0";
    private String btn6 = "0";
    private String btn7 = "0";
    private String lastResult = "";

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBtn4() {
        return btn4;
    }

    public void setBtn4(String btn4) {
        this.btn4 = btn4;
    }

    public String getBtn5() {
        return btn5;
    }

    public void setBtn5(String btn5) {
        this.btn5 = btn5;
    }

    public String getBtn6() {
        return btn6;
    }

    public void setBtn6(String btn6) {
        this.btn6 = btn6;
    }

    public String getBtn7() {
        return btn7;
    }

    public void setBtn7(String btn7) {
        this.btn7 = btn7;
    }
}
