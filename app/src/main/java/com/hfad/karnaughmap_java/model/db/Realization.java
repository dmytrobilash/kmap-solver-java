package com.hfad.karnaughmap_java.model.db;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Realization implements Repository{
    private Dao dao;

    public Realization(Dao dao) {
        this.dao = dao;
    }

    @Override
    public String getButton() {
        return dao.getButtons();
    }

    @Override
    public void setButton(String buttons, Runnable onSuccess) {
        dao.setButtons(buttons);
        onSuccess.run();
    }
}
