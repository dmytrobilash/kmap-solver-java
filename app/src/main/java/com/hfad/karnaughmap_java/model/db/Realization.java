package com.hfad.karnaughmap_java.model.db;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Realization implements Dao{
    private Dao dao;

    public Realization(Dao dao) {
        this.dao = dao;
    }

    @Override
    public LiveData<List<Table2>> get2(){
        return dao.get2();
    }

    @Override
    public String update2(String string) {
        return null;
    }
}
