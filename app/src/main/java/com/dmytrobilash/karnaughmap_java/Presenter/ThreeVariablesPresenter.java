package com.dmytrobilash.karnaughmap_java.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.dmytrobilash.karnaughmap_java.model.PoS.ThreeVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.PoS.TwoVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.SoP.ThreeVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.SoP.TwoVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.db.KmapDatabase;
import com.dmytrobilash.karnaughmap_java.model.db.Var2;
import com.dmytrobilash.karnaughmap_java.model.db.Var3;

import java.util.Arrays;

public class ThreeVariablesPresenter {

    private Var3 var3 = new Var3();
    private Context context;
    private Button[] buttons;
    private Button changeForm;
    int[] val;

    public ThreeVariablesPresenter(Button[] buttons, Button changeForm, Context context) {
        this.context = context;
        this.buttons = buttons;
        this.changeForm = changeForm;
    }

    private void buttonsToInt() {

        val = new int[8];
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
        return new ThreeVariablesSoP(val).solve();
    }

    public String getGroupsSoP() {
        buttonsToInt();
        return new ThreeVariablesSoP(val).getGroups();
    }

    public String getResPoS() {
        buttonsToInt();
        return new ThreeVariablesPoS(val).solve();
    }

    public String getGroupsPoS() {
        buttonsToInt();
        return new ThreeVariablesPoS(val).getGroups();
    }

    public void set0() {
        var3.setBtn0("0");
        var3.setBtn1("0");
        var3.setBtn2("0");
        var3.setBtn3("0");
        var3.setBtn4("0");
        var3.setBtn5("0");
        var3.setBtn6("0");
        var3.setBtn7("0");
        updateForm(changeForm);
        KmapDatabase.getInstance(context).myDataDao().updateVar3(var3);
    }

    public void set1() {
        var3.setBtn0("1");
        var3.setBtn1("1");
        var3.setBtn2("1");
        var3.setBtn3("1");
        var3.setBtn4("1");
        var3.setBtn5("1");
        var3.setBtn6("1");
        var3.setBtn7("1");
        updateForm(changeForm);
        KmapDatabase.getInstance(context).myDataDao().updateVar3(var3);
    }

    public void initButtonsValues(Button[] b, EditText editText) {
        Log.v("AAAAA", "2");
        KmapDatabase.getInstance(context).myDataDao().insertVar3(var3);
        KmapDatabase.getInstance(context).myDataDao().getButtonsVar3().observeForever( myData -> {
            if (myData != null) {
                b[0].setText(myData.getBtn0());
                b[1].setText(myData.getBtn1());
                b[2].setText(myData.getBtn2());
                b[3].setText(myData.getBtn3());
                b[4].setText(myData.getBtn4());
                b[5].setText(myData.getBtn5());
                b[6].setText(myData.getBtn6());
                b[7].setText(myData.getBtn7());
                editText.setText(myData.getLastResult());
                changeForm.setText(myData.getForm());
                var3.setBtn0(myData.getBtn0());
                var3.setBtn1(myData.getBtn1());
                var3.setBtn2(myData.getBtn2());
                var3.setBtn3(myData.getBtn3());
                var3.setBtn4(myData.getBtn4());
                var3.setBtn5(myData.getBtn5());
                var3.setBtn6(myData.getBtn6());
                var3.setBtn7(myData.getBtn7());
                var3.setLastResult(myData.getLastResult());
                var3.setForm(myData.getForm());
            }
        });
    }

    public void updateButtonValues(Button b) {
        int buttonIndex = Arrays.asList(buttons).indexOf(b);
        Log.v("Buttons", String.valueOf(buttonIndex));
        if (b.getText().toString().equals("0")) {
            if (buttonIndex == 0) {
                var3.setBtn0("1");
                b.setText("1");
            } else if (buttonIndex == 1) {
                var3.setBtn1("1");
                b.setText("1");
            } else if (buttonIndex == 2) {
                var3.setBtn2("1");
                b.setText("1");
            } else if (buttonIndex == 3) {
                var3.setBtn3("1");
                b.setText("1");
            } else if (buttonIndex == 4) {
                var3.setBtn4("1");
                b.setText("1");
            } else if (buttonIndex == 5) {
                var3.setBtn5("1");
                b.setText("1");
            } else if (buttonIndex == 6) {
                var3.setBtn6("1");
                b.setText("1");
            } else {
                var3.setBtn7("1");
                b.setText("1");
            }
        } else if (b.getText().toString().equals("1")) {
            if (buttonIndex == 0) {
                var3.setBtn0("X");
                b.setText("X");
            } else if (buttonIndex == 1) {
                var3.setBtn1("X");
                b.setText("X");
            } else if (buttonIndex == 2) {
                var3.setBtn2("X");
                b.setText("X");
            } else if (buttonIndex == 3) {
                var3.setBtn3("X");
                b.setText("X");
            } else if (buttonIndex == 4) {
                var3.setBtn4("X");
                b.setText("X");
            } else if (buttonIndex == 5) {
                var3.setBtn5("X");
                b.setText("X");
            } else if (buttonIndex == 6) {
                var3.setBtn6("X");
                b.setText("X");
            } else {
                var3.setBtn7("X");
                b.setText("X");
            }
        } else {
            if (buttonIndex == 0) {
                var3.setBtn0("0");
                b.setText("0");
            } else if (buttonIndex == 1) {
                var3.setBtn1("0");
                b.setText("0");
            } else if (buttonIndex == 2) {
                var3.setBtn2("0");
                b.setText("0");
            } else if (buttonIndex == 3) {
                var3.setBtn3("0");
                b.setText("0");
            } else if (buttonIndex == 4) {
                var3.setBtn4("0");
                b.setText("0");
            } else if (buttonIndex == 5) {
                var3.setBtn5("0");
                b.setText("0");
            } else if (buttonIndex == 6) {
                var3.setBtn6("0");
                b.setText("0");
            } else {
                var3.setBtn7("0");
                b.setText("0");
            }
        }
        updateForm(changeForm);
    }

    public void updateForm(Button changeForm){
        if(changeForm.getText().toString().equals("SoP")){
            var3.setLastResult(getResSoP());
        }else{
            var3.setLastResult(getResPoS());
        }
        var3.setForm(changeForm.getText().toString());
        KmapDatabase.getInstance(context).myDataDao().updateVar3(var3);
    }
}