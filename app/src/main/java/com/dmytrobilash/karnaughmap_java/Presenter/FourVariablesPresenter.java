package com.dmytrobilash.karnaughmap_java.Presenter;

import com.dmytrobilash.karnaughmap_java.model.PoS.FourVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.SoP.FourVariablesSoP;

public class FourVariablesPresenter {
    private final String res;
    private final String groups;
    private final String resPoS;
    private final String groupsPoS;

    public FourVariablesPresenter(int[] val){
        this.res = new FourVariablesSoP(val).solve();
        this.groups = new FourVariablesSoP(val).getGroups();
        this.resPoS = new FourVariablesPoS(val).solve();
        this.groupsPoS = new FourVariablesPoS(val).getGroups();
    }

    public String getRes() {
        return res;
    }
    public String getGroups() {return groups;}
    public String getGroupsPoS(){return groupsPoS;}
}
