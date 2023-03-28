package com.hfad.karnaughmap_java.Presenter;

import com.hfad.karnaughmap_java.model.FourVariables;

public class FourVariablePresenter {
    private final String res;

    public FourVariablePresenter(int[] val){
        this.res = new FourVariables(val).solve();
    }

    public String getRes() {
        return res;
    }
}
