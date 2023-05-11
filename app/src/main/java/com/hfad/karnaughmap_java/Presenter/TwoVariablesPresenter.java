package com.hfad.karnaughmap_java.Presenter;

import com.hfad.karnaughmap_java.model.SoP.TwoVariablesSoP;

public class TwoVariablesPresenter {

    private final String res;
    private final String groups;
    public TwoVariablesPresenter(int[] val){
        this.res = new TwoVariablesSoP(val).solve();
        this.groups = new TwoVariablesSoP(val).getGroups();
    }

    public String getRes() {
        return res;
    }
    public String getGroups() {return groups;}

}