package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hfad.karnaughmap_java.MainActivity;
import com.hfad.karnaughmap_java.Presenter.TwoVariablePresenter;
import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.model.TwoVariables;

public class Map2x2 extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons;
    private EditText planeText_SoP;
    private EditText planeText_PoS;
    private EditText planeText_grouping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2x2);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3)};
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
        planeText_SoP = findViewById(R.id.planeText_SoP);
        planeText_PoS = findViewById(R.id.planeText_PoS);
        planeText_grouping = findViewById(R.id.planeText_grouping);
        Button solve = findViewById(R.id.solve);
        Button scheme = findViewById(R.id.get_scheme);
        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Map2x2.this, DrawSchemeActivity.class);
                Log.v("AAAA", String.valueOf(planeText_SoP.getText()));
                switchActivityIntent.putExtra("result", String.valueOf(planeText_SoP.getText()));
                startActivity(switchActivityIntent);
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] val;
                String soln;

                // executes when two variable is selected
                val = new int[4];

                for (int i = 0; i < val.length; i++) {
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }
                TwoVariablePresenter twoVariablePresenter = new TwoVariablePresenter(val);

                soln = twoVariablePresenter.getRes();

                // sets the result to text pane
                if (soln.isEmpty()) {
                    planeText_SoP.setText(null);
                    planeText_PoS.setText(null);
                    planeText_grouping.setText(null);
                } else {
                    planeText_SoP.setText(soln);
                    //planeText_PoS.setText(solver.SoPtoPoSConverter(soln));
                    //planeText_grouping.setText(solver.getGroups());
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        Button b = (Button) v;

        if (b.getText().toString().matches("0")) {
            b.setText("1");
        } else if (b.getText().toString().matches("1")) {
            b.setText("X");
        } else {
            b.setText("0");
        }
    }
}
