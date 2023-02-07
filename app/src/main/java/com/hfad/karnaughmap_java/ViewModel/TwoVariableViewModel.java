package com.hfad.karnaughmap_java.ViewModel;


import android.util.Log;

import androidx.lifecycle.ViewModel;

public class TwoVariableViewModel extends ViewModel {
    public TwoVariableViewModel(){
        Log.i("VM", "VM created");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("VM", "VM Cleared");
    }
}
