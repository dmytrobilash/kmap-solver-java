package com.hfad.karnaughmap_java;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

class ResultTypeOptimizer {
    private String optimizedSolution;

    public ResultTypeOptimizer(Context context, final String sop, final EditText textpane) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setTitle("Choose result type")
                .setMessage("SoP or PoS?")
                .setNegativeButton("SoP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        optimizedSolution = sop;
                        textpane.setText(optimizedSolution);
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("PoS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SoPtoPoSConverter(sop, textpane);
                        dialog.dismiss();
                    }
                }).show();
        alertDialog.create();
    }

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
