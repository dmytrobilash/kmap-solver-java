package com.dmytrobilash.karnaughmap_java.Presenter;

import com.dmytrobilash.karnaughmap_java.model.PoS.FourVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.PoS.TwoVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.SoP.FourVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.SoP.TwoVariablesSoP;

public class FourVariablesPresenter {
    private final String resSoP;
    private final String groupsSoP;
    private final String resPoS;
    private final String groupsPoS;

    public FourVariablesPresenter(int[] val){
        this.resSoP = new FourVariablesSoP(val).solve();
        this.groupsSoP = new FourVariablesSoP(val).getGroups();
        this.resPoS = new FourVariablesPoS(val).solve();
        this.groupsPoS = new FourVariablesPoS(val).getGroups();
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
