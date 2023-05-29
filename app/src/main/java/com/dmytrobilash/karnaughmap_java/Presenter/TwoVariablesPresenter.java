package com.dmytrobilash.karnaughmap_java.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dmytrobilash.karnaughmap_java.model.PoS.TwoVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.SoP.TwoVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.db.KmapDatabase;
import com.dmytrobilash.karnaughmap_java.model.db.Var2;
import com.dmytrobilash.karnaughmap_java.views.Kmap2VariablesActivity;

import java.util.Arrays;

public class TwoVariablesPresenter {

    private Var2 var2 = new Var2();
    private Context context;
    private Button[] buttons;
    private Button changeForm;
    int[] val;

    public TwoVariablesPresenter(Button[] buttons, Button changeForm, Context context) {
        this.context = context;
        this.buttons = buttons;
        this.changeForm = changeForm;
    }

    private void buttonsToInt() {

        val = new int[4];
        for (int i = 0; i < val.length; i++) {
            if (buttons[i].getText().toString().matches("X")) {
                val[i] = 2;
            } else {
                val[i] = Integer.parseInt(buttons[i].getText().toString());
            }
        }
    }

    public String getResSoP() {
        buttonsToInt();
        return new TwoVariablesSoP(val).solve();
    }

    public String getGroupsSoP() {
        buttonsToInt();
        return new TwoVariablesSoP(val).getGroups();
    }

    public String getResPoS() {
        buttonsToInt();
        return new TwoVariablesPoS(val).solve();
    }

    public String getGroupsPoS() {
        buttonsToInt();
        return new TwoVariablesPoS(val).getGroups();
    }

    public void set0() {
        var2.setBtn0("0");
        var2.setBtn1("0");
        var2.setBtn2("0");
        var2.setBtn3("0");
        KmapDatabase.getInstance(context).myDataDao().updateVar2(var2);
        updateForm(changeForm);
    }

    public void set1() {
        var2.setBtn0("1");
        var2.setBtn1("1");
        var2.setBtn2("1");
        var2.setBtn3("1");
        updateForm(changeForm);
        KmapDatabase.getInstance(context).myDataDao().updateVar2(var2);
    }

    public void initButtonsValues(Button[] b, EditText editText) {
        Log.v("AAAAA", "2");
        KmapDatabase.getInstance(context).myDataDao().insertVar2(var2);
        KmapDatabase.getInstance(context).myDataDao().getButtonsVar2().observeForever( myData -> {
            if (myData != null) {
                b[0].setText(myData.getBtn0());
                b[1].setText(myData.getBtn1());
                b[2].setText(myData.getBtn2());
                b[3].setText(myData.getBtn3());
                editText.setText(myData.getLastResult());
                changeForm.setText(myData.getForm());
                var2.setBtn0(myData.getBtn0());
                var2.setBtn1(myData.getBtn1());
                var2.setBtn2(myData.getBtn2());
                var2.setBtn3(myData.getBtn3());
                var2.setLastResult(myData.getLastResult());
                var2.setForm(myData.getForm());
            }
        });
    }

    public void updateButtonValues(Button b) {
        int buttonIndex = Arrays.asList(buttons).indexOf(b);
        Log.v("Buttons", String.valueOf(buttonIndex));
        if (b.getText().toString().equals("0")) {
            if (buttonIndex == 0) {
                var2.setBtn0("1");
                b.setText("1");
            } else if (buttonIndex == 1) {
                var2.setBtn1("1");
                b.setText("1");
            } else if (buttonIndex == 2) {
                var2.setBtn2("1");
                b.setText("1");
            } else {
                var2.setBtn3("1");
                b.setText("1");
            }
        } else if (b.getText().toString().equals("1")) {
            if (buttonIndex == 0) {
                var2.setBtn0("X");
                b.setText("X");
            } else if (buttonIndex == 1) {
                var2.setBtn1("X");
                b.setText("X");
            } else if (buttonIndex == 2) {
                var2.setBtn2("X");
                b.setText("X");
            } else {
                var2.setBtn3("X");
                b.setText("X");
            }
        } else {
            if (buttonIndex == 0) {
                var2.setBtn0("0");
                b.setText("0");
            } else if (buttonIndex == 1) {
                var2.setBtn1("0");
                b.setText("0");
            } else if (buttonIndex == 2) {
                var2.setBtn2("0");
                b.setText("0");
            } else {
                var2.setBtn3("0");
                b.setText("0");
            }
        }
        updateForm(changeForm);

    }

    public void updateForm(Button changeForm){
        if(changeForm.getText().toString().equals("SoP")){
            var2.setLastResult(getResSoP());
        }else{
            var2.setLastResult(getResPoS());
        }
        var2.setForm(changeForm.getText().toString());
        KmapDatabase.getInstance(context).myDataDao().updateVar2(var2);
    }
}