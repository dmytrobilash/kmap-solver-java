package com.hfad.karnaughmap_java.Presenter.twoVars;

import com.hfad.karnaughmap_java.model.TwoVariables;
import com.hfad.karnaughmap_java.model.db.Var2;

public class TwoVariablePresenter  {

    private final String res;
    private final String groups;
    public TwoVariablePresenter(int[] val){
        this.res = new TwoVariables(val).solve();
        this.groups = new TwoVariables(val).getGroups();
    }

    public String getRes() {
        return res;
    }
    public String getGroups() {return groups;}

}