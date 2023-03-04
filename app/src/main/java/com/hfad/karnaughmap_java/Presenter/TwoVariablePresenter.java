package com.hfad.karnaughmap_java.Presenter;

import com.hfad.karnaughmap_java.model.TwoVariables;

public class TwoVariablePresenter  {

    private final String res;

    public TwoVariablePresenter(int[] val){
        this.res = new TwoVariables(val).solve();
    }

    public String getRes() {
        return res;
    }
}