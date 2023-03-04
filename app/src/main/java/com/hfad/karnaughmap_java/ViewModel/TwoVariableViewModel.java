package com.hfad.karnaughmap_java.ViewModel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hfad.karnaughmap_java.solvers.TwoVariables;

import java.util.Arrays;

public class TwoVariableViewModel extends ViewModel {
    public TwoVariableViewModel(){
        Log.i("VM", "VM created");
    }
    public MutableLiveData<String> liveData = new MutableLiveData<>();

    public void result(int[] val){

        Log.v("BBB", Arrays.toString(val));
        TwoVariables solver = new TwoVariables(val);
        liveData.setValue(solver.solve());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("VM", "VM Cleared");
    }
}
