package com.dmytrobilash.karnaughmap_java.Presenter;

import com.dmytrobilash.karnaughmap_java.model.SoP.ThreeVariablesSoP;

public class ThreeVariablesPresenter {
    private final String res;
    private final String groups;
    public ThreeVariablesPresenter(int[] val){
        this.res = new ThreeVariablesSoP(val).solve();
        this.groups = new ThreeVariablesSoP(val).getGroups();
    }

    public String getRes() {
        return res;
    }
    public String getGroups() {return groups;}
}
