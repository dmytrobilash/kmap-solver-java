package com.hfad.karnaughmap_java;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

class ResultTypeOptimizer {
    private String optimizedSolution;


    private void SoPtoPoSConverter(String sop, EditText textpane) {
        String i1 = sop.replace(" + ", ") * (");
        String i2 = "(" + i1.replace("'", " + ") + ")";
        String i3 = "";

        for (int i = 0; i < i2.length(); i++) {
            String ch;
            if (i2.charAt(i) == 'A' || i2.charAt(i) == 'B' || i2.charAt(i) == 'C' || i2.charAt(i) == 'D') {
                if (!i2.regionMatches(i + 1, " + ", 0, 3)) {
                    ch = i2.charAt(i) + "' + ";
                } else {
                    ch = Character.toString(i2.charAt(i));
                }
            } else {
                ch = Character.toString(i2.charAt(i));
            }
            i3 += ch;
        }
        optimizedSolution = i3.replace(" + )", ")");
        textpane.setText(optimizedSolution);
    }
}
