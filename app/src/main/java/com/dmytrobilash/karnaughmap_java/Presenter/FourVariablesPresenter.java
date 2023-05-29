package com.dmytrobilash.karnaughmap_java.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.dmytrobilash.karnaughmap_java.model.PoS.FourVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.PoS.ThreeVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.PoS.TwoVariablesPoS;
import com.dmytrobilash.karnaughmap_java.model.SoP.FourVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.SoP.ThreeVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.SoP.TwoVariablesSoP;
import com.dmytrobilash.karnaughmap_java.model.db.KmapDatabase;
import com.dmytrobilash.karnaughmap_java.model.db.Var3;
import com.dmytrobilash.karnaughmap_java.model.db.Var4;

import java.util.Arrays;

public class FourVariablesPresenter {
    private Var4 var4 = new Var4();
    private Context context;
    private Button[] buttons;
    private Button changeForm;
    int[] val;

    public FourVariablesPresenter(Button[] buttons, Button changeForm, Context context) {
        this.context = context;
        this.buttons = buttons;
        this.changeForm = changeForm;
    }

    private void buttonsToInt() {

        val = new int[16];
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
        return new FourVariablesSoP(val).solve();
    }

    public String getGroupsSoP() {
        buttonsToInt();
        return new FourVariablesSoP(val).getGroups();
    }

    public String getResPoS() {
        buttonsToInt();
        return new FourVariablesPoS(val).solve();
    }

    public String getGroupsPoS() {
        buttonsToInt();
        return new FourVariablesPoS(val).getGroups();
    }

    public void set0() {
        var4.setBtn0("0");
        var4.setBtn1("0");
        var4.setBtn2("0");
        var4.setBtn3("0");
        var4.setBtn4("0");
        var4.setBtn5("0");
        var4.setBtn6("0");
        var4.setBtn7("0");
        var4.setBtn8("0");
        var4.setBtn9("0");
        var4.setBtn10("0");
        var4.setBtn11("0");
        var4.setBtn12("0");
        var4.setBtn13("0");
        var4.setBtn14("0");
        var4.setBtn15("0");
        updateForm(changeForm);
        KmapDatabase.getInstance(context).myDataDao().updateVar4(var4);
    }

    public void set1() {
        var4.setBtn0("1");
        var4.setBtn1("1");
        var4.setBtn2("1");
        var4.setBtn3("1");
        var4.setBtn4("1");
        var4.setBtn5("1");
        var4.setBtn6("1");
        var4.setBtn7("1");
        var4.setBtn8("1");
        var4.setBtn9("1");
        var4.setBtn10("1");
        var4.setBtn11("1");
        var4.setBtn12("1");
        var4.setBtn13("1");
        var4.setBtn14("1");
        var4.setBtn15("1");
        updateForm(changeForm);
        KmapDatabase.getInstance(context).myDataDao().updateVar4(var4);
    }

    public void initButtonsValues(Button[] b, EditText editText) {

        KmapDatabase.getInstance(context).myDataDao().insertVar4(var4);
        KmapDatabase.getInstance(context).myDataDao().getButtonsVar4().observeForever( myData -> {
            if (myData != null) {
                b[0].setText(myData.getBtn0());
                b[1].setText(myData.getBtn1());
                b[2].setText(myData.getBtn2());
                b[3].setText(myData.getBtn3());
                b[4].setText(myData.getBtn4());
                b[5].setText(myData.getBtn5());
                b[6].setText(myData.getBtn6());
                b[7].setText(myData.getBtn7());
                b[8].setText(myData.getBtn8());
                b[9].setText(myData.getBtn9());
                b[10].setText(myData.getBtn10());
                b[11].setText(myData.getBtn11());
                b[12].setText(myData.getBtn12());
                b[13].setText(myData.getBtn13());
                b[14].setText(myData.getBtn14());
                b[15].setText(myData.getBtn15());
                editText.setText(myData.getLastResult());
                changeForm.setText(myData.getForm());
                var4.setBtn0(myData.getBtn0());
                var4.setBtn1(myData.getBtn1());
                var4.setBtn2(myData.getBtn2());
                var4.setBtn3(myData.getBtn3());
                var4.setBtn4(myData.getBtn4());
                var4.setBtn5(myData.getBtn5());
                var4.setBtn6(myData.getBtn6());
                var4.setBtn7(myData.getBtn7());
                var4.setBtn8(myData.getBtn8());
                var4.setBtn9(myData.getBtn9());
                var4.setBtn10(myData.getBtn10());
                var4.setBtn11(myData.getBtn11());
                var4.setBtn12(myData.getBtn12());
                var4.setBtn13(myData.getBtn13());
                var4.setBtn14(myData.getBtn14());
                var4.setBtn15(myData.getBtn15());
                var4.setLastResult(myData.getLastResult());
                var4.setForm(myData.getForm());
            }
        });
    }

    public void updateButtonValues(Button b) {
        int buttonIndex = Arrays.asList(buttons).indexOf(b);
        Log.v("Buttons", String.valueOf(buttonIndex));
        if (b.getText().toString().equals("0")) {
            if (buttonIndex == 0) {
                var4.setBtn0("1");
                b.setText("1");
            } else if (buttonIndex == 1) {
                var4.setBtn1("1");
                b.setText("1");
            } else if (buttonIndex == 2) {
                var4.setBtn2("1");
                b.setText("1");
            } else if (buttonIndex == 3) {
                var4.setBtn3("1");
                b.setText("1");
            } else if (buttonIndex == 4) {
                var4.setBtn4("1");
                b.setText("1");
            } else if (buttonIndex == 5) {
                var4.setBtn5("1");
                b.setText("1");
            } else if (buttonIndex == 6) {
                var4.setBtn6("1");
                b.setText("1");
            } else if (buttonIndex == 7) {
                var4.setBtn7("1");
                b.setText("1");
            } else if (buttonIndex == 8) {
                var4.setBtn8("1");
                b.setText("1");
            } else if (buttonIndex == 9) {
                var4.setBtn9("1");
                b.setText("1");
            } else if (buttonIndex == 10) {
                var4.setBtn10("1");
                b.setText("1");
            } else if (buttonIndex == 11) {
                var4.setBtn11("1");
                b.setText("1");
            } else if (buttonIndex == 12) {
                var4.setBtn12("1");
                b.setText("1");
            } else if (buttonIndex == 13) {
                var4.setBtn13("1");
                b.setText("1");
            } else if (buttonIndex == 14) {
                var4.setBtn14("1");
                b.setText("1");
            } else if (buttonIndex == 15) {
                var4.setBtn15("1");
                b.setText("1");
            }
        } else if (b.getText().toString().equals("1")) {
            if (buttonIndex == 0) {
                var4.setBtn0("X");
                b.setText("X");
            } else if (buttonIndex == 1) {
                var4.setBtn1("X");
                b.setText("X");
            } else if (buttonIndex == 2) {
                var4.setBtn2("X");
                b.setText("X");
            } else if (buttonIndex == 3) {
                var4.setBtn3("X");
                b.setText("X");
            } else if (buttonIndex == 4) {
                var4.setBtn4("X");
                b.setText("X");
            } else if (buttonIndex == 5) {
                var4.setBtn5("X");
                b.setText("X");
            } else if (buttonIndex == 6) {
                var4.setBtn6("X");
                b.setText("X");
            } else if (buttonIndex == 7) {
                var4.setBtn7("X");
                b.setText("X");
            } else if (buttonIndex == 8) {
                var4.setBtn8("X");
                b.setText("X");
            } else if (buttonIndex == 9) {
                var4.setBtn9("X");
                b.setText("X");
            } else if (buttonIndex == 10) {
                var4.setBtn10("X");
                b.setText("X");
            } else if (buttonIndex == 11) {
                var4.setBtn11("X");
                b.setText("X");
            } else if (buttonIndex == 12) {
                var4.setBtn12("X");
                b.setText("X");
            } else if (buttonIndex == 13) {
                var4.setBtn13("X");
                b.setText("X");
            } else if (buttonIndex == 14) {
                var4.setBtn14("X");
                b.setText("X");
            } else if (buttonIndex == 15) {
                var4.setBtn15("X");
                b.setText("X");
            }
        } else {
            if (buttonIndex == 0) {
                var4.setBtn0("0");
                b.setText("0");
            } else if (buttonIndex == 1) {
                var4.setBtn1("0");
                b.setText("0");
            } else if (buttonIndex == 2) {
                var4.setBtn2("0");
                b.setText("0");
            } else if (buttonIndex == 3) {
                var4.setBtn3("0");
                b.setText("0");
            } else if (buttonIndex == 4) {
                var4.setBtn4("0");
                b.setText("0");
            } else if (buttonIndex == 5) {
                var4.setBtn5("0");
                b.setText("0");
            } else if (buttonIndex == 6) {
                var4.setBtn6("0");
                b.setText("0");
            } else if (buttonIndex == 7) {
                var4.setBtn7("0");
                b.setText("0");
            } else if (buttonIndex == 8) {
                var4.setBtn8("0");
                b.setText("0");
            } else if (buttonIndex == 9) {
                var4.setBtn9("0");
                b.setText("0");
            } else if (buttonIndex == 10) {
                var4.setBtn10("0");
                b.setText("0");
            } else if (buttonIndex == 11) {
                var4.setBtn11("0");
                b.setText("0");
            } else if (buttonIndex == 12) {
                var4.setBtn12("0");
                b.setText("0");
            } else if (buttonIndex == 13) {
                var4.setBtn13("0");
                b.setText("0");
            } else if (buttonIndex == 14) {
                var4.setBtn14("0");
                b.setText("0");
            } else if (buttonIndex == 15) {
                var4.setBtn15("0");
                b.setText("0");
            }
        }
        updateForm(changeForm);
    }

    public void updateForm(Button changeForm){
        if(changeForm.getText().toString().equals("SoP")){
            var4.setLastResult(getResSoP());
        }else{
            var4.setLastResult(getResPoS());
        }
        var4.setForm(changeForm.getText().toString());
        KmapDatabase.getInstance(context).myDataDao().updateVar4(var4);
    }
}