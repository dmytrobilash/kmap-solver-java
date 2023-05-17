package com.dmytrobilash.karnaughmap_java.Presenter;

import com.dmytrobilash.karnaughmap_java.model.PoS.TwoVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.SoP.ThreeVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.SoP.TwoVariablesSoP;

public class ThreeVariablesPresenter {
    private final String resSoP;
    private final String groupsSoP;
    private final String resPoS;
    private final String groupsPoS;

    public ThreeVariablesPresenter(int[] val){
        this.resSoP = new TwoVariablesSoP(val).solve();
        this.groupsSoP = new TwoVariablesSoP(val).getGroups();
        this.resPoS = new TwoVariablesPoS(val).solve();
        this.groupsPoS = new TwoVariablesPoS(val).getGroups();
    }

    public String getResSoP() {
        return resSoP;
    }

    public String getGroupsSoP() {
        return groupsSoP;
    }

    public String getResPoS() {
        return resPoS;
    }

    public String getGroupsPoS() {
        return groupsPoS;
    }
}
