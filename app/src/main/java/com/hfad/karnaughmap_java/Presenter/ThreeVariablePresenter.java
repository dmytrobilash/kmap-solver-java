package com.hfad.karnaughmap_java.Presenter;

import com.hfad.karnaughmap_java.model.ThreeVariables;


public class ThreeVariablePresenter {
    private final String res;

    public ThreeVariablePresenter(int[] val){
        this.res = new ThreeVariables(val).solve();
    }

    public String getRes() {
        return res;
    }
}
