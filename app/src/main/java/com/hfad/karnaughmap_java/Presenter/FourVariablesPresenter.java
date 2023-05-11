package com.hfad.karnaughmap_java.Presenter;

import com.hfad.karnaughmap_java.model.SoP.FourVariablesSoP;
import com.hfad.karnaughmap_java.model.SoP.TwoVariablesSoP;

public class FourVariablesPresenter {
    private final String res;
    private final String groups;

    public FourVariablesPresenter(int[] val){
        this.res = new FourVariablesSoP(val).solve();
        this.groups = new FourVariablesSoP(val).getGroups();
    }

    public String getRes() {
        return res;
    }
    public String getGroups() {return groups;}
}
