package com.hfad.karnaughmap_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class map2x2 extends AppCompatActivity  implements View.OnClickListener {
    private Button[] buttons;
    private EditText planeText_SoP;
    private EditText planeText_PoS;
    private Button solve;
    private Button b;
    Button switchToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2x2);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3)};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }

        planeText_SoP = findViewById(R.id.planeText_SoP);
        planeText_PoS = findViewById(R.id.planeText_PoS);
        solve = findViewById(R.id.solve);

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int [] val;
                String soln;

                // executes when two variable is selected
                val = new int[4];

                for (int i = 0; i < val.length; i++) {
                    // stores value from button text
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }

                // creates instance of two variable solver
                map2x2_solver solver = new map2x2_solver(val);
                // solves and stores result
                soln = solver.solve();

                // sets the result to text pane
                if (soln.isEmpty()) {
                    planeText_SoP.setText(null);
                    planeText_PoS.setText(null);
                } else {
                    planeText_SoP.setText(soln);
                    planeText_PoS.setText(SoPtoPoSConverter(soln));
                }
            }
        });
        switchToSecondActivity = findViewById(R.id.get_scheme);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    @Override
    public void onClick(View v) {
        b = (Button) v;

        if (b.getText().toString().matches("0")) {
            b.setText("1");
        } else if(b.getText().toString().matches("1")){
            b.setText("X");
        }
        else {
            b.setText("0");

        }
    }

    private Context getContext() {
        return this;
    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, Map2x2SchemeActivity.class);
        startActivity(switchActivityIntent);
    }
    private String SoPtoPoSConverter(String sop) {
        String optimizedSolution;
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
        return optimizedSolution;
    }

}
