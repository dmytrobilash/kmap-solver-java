package com.hfad.karnaughmap_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class map2x2 extends AppCompatActivity  implements View.OnClickListener {
    private Button[] buttons;
    private EditText textpane;
    private Button solve;
    private Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2x2);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3)};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }

        textpane = findViewById(R.id.plaheText);
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
                    textpane.setText(null);
                } else {
                    new ResultTypeOptimizer(getContext(), soln, textpane);
                }
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
}