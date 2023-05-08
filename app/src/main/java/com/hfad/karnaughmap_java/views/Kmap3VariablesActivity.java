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
import com.hfad.karnaughmap_java.model.db.Var3;
import com.hfad.karnaughmap_java.views.drawing.DrawSchemeActivity;

import java.util.Arrays;

public class Kmap3VariablesActivity extends AppCompatActivity implements View.OnClickListener {
    Var3 var3;
    EditText editText;
    private Button[] buttons;
    private Button scheme;
    private Button solve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kmap3_variables);
        editText = findViewById(R.id.planeText_SoP);
        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6), findViewById(R.id.button7)};

        solve = findViewById(R.id.solve);
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] val;
                String soln;

                val = new int[8];

                for (int i = 0; i < val.length; i++) {
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }
                /*ThreeVariablePresenter threeVariablePresenter = new ThreeVariablePresenter(val);

                soln = threeVariablePresenter.getRes();

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
                Intent switchActivityIntent = new Intent(Kmap3VariablesActivity.this, DrawSchemeActivity.class);
                Log.v("AAAA", String.valueOf(editText.getText()));
                switchActivityIntent.putExtra("result", String.valueOf(editText.getText()));
                startActivity(switchActivityIntent);
            }
        });
        var3 = new Var3();
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().insertVar3(var3);
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().getButtonsVar3().observe(Kmap3VariablesActivity.this, myData -> {
            if (myData != null) {
                // Update the text for all the buttons
                buttons[0].setText(myData.getBtn0());
                buttons[1].setText(myData.getBtn1());
                buttons[2].setText(myData.getBtn2());
                buttons[3].setText(myData.getBtn3());
                buttons[4].setText(myData.getBtn4());
                buttons[5].setText(myData.getBtn5());
                buttons[6].setText(myData.getBtn6());
                buttons[7].setText(myData.getBtn7());
                // Update the state of the Var2 object
                var3.setBtn0(myData.getBtn0());
                var3.setBtn1(myData.getBtn1());
                var3.setBtn2(myData.getBtn2());
                var3.setBtn3(myData.getBtn3());
                var3.setBtn4(myData.getBtn4());
                var3.setBtn5(myData.getBtn5());
                var3.setBtn6(myData.getBtn6());
                var3.setBtn7(myData.getBtn7());
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
                var3.setBtn0("1");
                b.setText("1");
            } else if (buttonIndex == 1) {
                var3.setBtn1("1");
                b.setText("1");
            } else if (buttonIndex == 2) {
                var3.setBtn2("1");
                b.setText("1");
            } else if (buttonIndex == 3){
                var3.setBtn3("1");
                b.setText("1");
            }else if (buttonIndex == 4) {
                var3.setBtn4("1");
                b.setText("1");
            } else if (buttonIndex == 5) {
                var3.setBtn5("1");
                b.setText("1");
            } else if (buttonIndex == 6){
                var3.setBtn6("1");
                b.setText("1");
            }else {
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
        // Update the database
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().updateVar3(var3);
    }
}