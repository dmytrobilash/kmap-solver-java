package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hfad.karnaughmap_java.Presenter.FourVariablePresenter;
import com.hfad.karnaughmap_java.Presenter.ThreeVariablePresenter;
import com.hfad.karnaughmap_java.Presenter.TwoVariablePresenter;
import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.views.drawing.DrawSchemeActivity;

public class Map4x4 extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    private Button[] buttons;
    private Button scheme;
    private Button solve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map4x4);
        editText = findViewById(R.id.planeText_SoP);
        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
                findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6), findViewById(R.id.button7),
                findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button10), findViewById(R.id.button11),
                findViewById(R.id.button12), findViewById(R.id.button13), findViewById(R.id.button14), findViewById(R.id.button15)};

        solve = findViewById(R.id.solve);
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
                FourVariablePresenter FourVariablePresenter = new FourVariablePresenter(val);

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
                }
            }
        });
        scheme = findViewById(R.id.get_scheme);
        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Map4x4.this, DrawSchemeActivity.class);
                Log.v("AAAA", String.valueOf(editText.getText()));
                switchActivityIntent.putExtra("result", String.valueOf(editText.getText()));
                startActivity(switchActivityIntent);
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