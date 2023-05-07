package com.hfad.karnaughmap_java.Presenter.twoVars;

import com.hfad.karnaughmap_java.model.TwoVariables;
import com.hfad.karnaughmap_java.model.db.Var2;

public class TwoVariablePresenter  {
    Var2 var2;

    private final String res;

    public TwoVariablePresenter(int[] val){
        this.res = new TwoVariables(val).solve();
    }

    public String getRes() {
        return res;
    }


}