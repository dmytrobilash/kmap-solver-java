package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.model.db.KmapDatabase;
import com.hfad.karnaughmap_java.model.db.Var4;
import com.hfad.karnaughmap_java.views.drawing.DrawSchemeActivity;

import java.util.Arrays;

public class Kmap4VariablesActivity extends AppCompatActivity implements View.OnClickListener {
    Var4 var4;
    EditText editText;
    private Button[] buttons;
    private Button scheme;
    private Button solve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kmap4_variables);
        editText = findViewById(R.id.planeText_SoP);
        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6), findViewById(R.id.button7),
                findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button10), findViewById(R.id.button11),
                findViewById(R.id.button12), findViewById(R.id.button13), findViewById(R.id.button14), findViewById(R.id.button15)};


        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] val;
                String soln;

                val = new int[16];

                for (int i = 0; i < val.length; i++) {
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }
                /*FourVariablePresenter FourVariablePresenter = new FourVariablePresenter(val);

                soln = FourVariablePresenter.getRes();

                // sets the result to text pane
                if (soln.isEmpty()) {
                    editText.setText(null);
                    editText.setText(null);
                    //planeText_grouping.setText(null);
                } else {
                    editText.setText(soln);
                    //planeText_PoS.setText(solver.SoPtoPoSConverter(soln));
                    //planeText_grouping.setText(solver.getGroups());
                }*/
            }
        });
        scheme = findViewById(R.id.get_scheme);
        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Kmap4VariablesActivity.this, DrawSchemeActivity.class);
                Log.v("AAAA", String.valueOf(editText.getText()));
                switchActivityIntent.putExtra("result", String.valueOf(editText.getText()));
                startActivity(switchActivityIntent);
            }
        });
        var4 = new Var4();
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().insertVar4(var4);
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().getButtonsVar4().observe(Kmap4VariablesActivity.this, myData -> {
            if (myData != null) {
                Log.v("Buttons", "Here");
                // Update the text for all the buttons
                buttons[0].setText(myData.getBtn0());
                buttons[1].setText(myData.getBtn1());
                buttons[2].setText(myData.getBtn2());
                buttons[3].setText(myData.getBtn3());
                buttons[4].setText(myData.getBtn4());
                buttons[5].setText(myData.getBtn5());
                buttons[6].setText(myData.getBtn6());
                buttons[7].setText(myData.getBtn7());
                buttons[8].setText(myData.getBtn8());
                buttons[9].setText(myData.getBtn9());
                buttons[10].setText(myData.getBtn10());
                buttons[11].setText(myData.getBtn11());
                buttons[12].setText(myData.getBtn12());
                buttons[13].setText(myData.getBtn13());
                buttons[14].setText(myData.getBtn14());
                buttons[15].setText(myData.getBtn15());

                // Update the state of the Var2 object
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
            }
        });
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        int buttonIndex = Arrays.asList(buttons).indexOf(b); // get the index of the clicked button
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
            } else if (buttonIndex == 3){
                var4.setBtn3("1");
                b.setText("1");
            }else if (buttonIndex == 4) {
                var4.setBtn4("1");
                b.setText("1");
            } else if (buttonIndex == 5) {
                var4.setBtn5("1");
                b.setText("1");
            } else if (buttonIndex == 6){
                var4.setBtn6("1");
                b.setText("1");
            } else if (buttonIndex == 7){
                var4.setBtn7("1");
                b.setText("1");
            } else if (buttonIndex == 8){
                var4.setBtn8("1");
                b.setText("1");
            } else if (buttonIndex == 9){
                var4.setBtn9("1");
                b.setText("1");
            } else if (buttonIndex == 10){
                var4.setBtn10("1");
                b.setText("1");
            } else if (buttonIndex == 11){
                var4.setBtn11("1");
                b.setText("1");
            } else if (buttonIndex == 12){
                var4.setBtn12("1");
                b.setText("1");
            } else if (buttonIndex == 13){
                var4.setBtn13("1");
                b.setText("1");
            } else if (buttonIndex == 14){
                var4.setBtn14("1");
                b.setText("1");
            } else if(buttonIndex == 15){
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
            }else if(buttonIndex == 15) {
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
            }else if (buttonIndex == 8) {
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
            } else if (buttonIndex == 15){
                var4.setBtn15("0");
                b.setText("0");
            }
        }
        // Update the database
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().updateVar4(var4);
    }
}