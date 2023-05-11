package com.dmytrobilash.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
        import android.widget.EditText;

import com.dmytrobilash.karnaughmap_java.Presenter.TwoVariablesPresenter;
import com.dmytrobilash.karnaughmap_java.R;
import com.dmytrobilash.karnaughmap_java.model.db.KmapDatabase;
import com.dmytrobilash.karnaughmap_java.model.db.Var2;
import com.dmytrobilash.karnaughmap_java.views.drawing.DrawSchemeActivity;
import com.dmytrobilash.karnaughmap_java.views.unions.CheckUnionsActivity;

import java.util.Arrays;

public class Kmap2VariablesActivity extends AppCompatActivity implements View.OnClickListener {
    private Var2 var2;
    private Button[] buttons;
    private EditText planeText_SoP;
    private EditText planeText_PoS;
    private TwoVariablesPresenter twoVariablePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmap2_variables);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3)};
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
        Button scheme = findViewById(R.id.get_scheme);
        Button set0 = findViewById(R.id.set0);
        Button set1 = findViewById(R.id.set1);
        Button unions = findViewById(R.id.unions);

        planeText_SoP = findViewById(R.id.planeText_SoP);
        planeText_PoS = findViewById(R.id.planeText_PoS);

        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Kmap2VariablesActivity.this, DrawSchemeActivity.class);
                switchActivityIntent.putExtra("result", String.valueOf(planeText_SoP.getText()));
                startActivity(switchActivityIntent);
            }
        });

        unions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = "";
                for(Button button: buttons){
                    buttonText += button.getText() + " ";
                }
                int[] val;
                String groups;
                // executes when two variable is selected
                val = new int[4];

                for (int i = 0; i < val.length; i++) {
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }
                twoVariablePresenter = new TwoVariablesPresenter(val);
                groups = twoVariablePresenter.getGroups();
                Intent switchActivityIntent = new Intent(Kmap2VariablesActivity.this, CheckUnionsActivity.class);
                switchActivityIntent.putExtra("kMap", "2");
                switchActivityIntent.putExtra("buttonText", buttonText);
                switchActivityIntent.putExtra("Groups", groups);
                startActivity(switchActivityIntent);
            }
        });

        var2 = new Var2();
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().insertVar2(var2);
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().getButtonsVar2().observe(Kmap2VariablesActivity.this, myData -> {
            if (myData != null) {
                // Update the text for all the buttons
                buttons[0].setText(myData.getBtn0());
                buttons[1].setText(myData.getBtn1());
                buttons[2].setText(myData.getBtn2());
                buttons[3].setText(myData.getBtn3());
                // Update the state of the Var2 object
                var2.setBtn0(myData.getBtn0());
                var2.setBtn1(myData.getBtn1());
                var2.setBtn2(myData.getBtn2());
                var2.setBtn3(myData.getBtn3());
                solve();
            }
        });

        set0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Button button : buttons) {
                    button.setText("0");
                }
                var2.setBtn0("0");
                var2.setBtn1("0");
                var2.setBtn2("0");
                var2.setBtn3("0");
                KmapDatabase.getInstance(getApplicationContext()).myDataDao().updateVar2(var2);
            }
        });

        set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Button button : buttons) {
                    button.setText("1");
                }
                var2.setBtn0("1");
                var2.setBtn1("1");
                var2.setBtn2("1");
                var2.setBtn3("1");
                KmapDatabase.getInstance(getApplicationContext()).myDataDao().updateVar2(var2);
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
                var2.setBtn0("1");
                b.setText("1");
            } else if (buttonIndex == 1) {
                var2.setBtn1("1");
                b.setText("1");
            } else if (buttonIndex == 2) {
                var2.setBtn2("1");
                b.setText("1");
            } else {
                var2.setBtn3("1");
                b.setText("1");
            }
        } else if (b.getText().toString().equals("1")) {
            if (buttonIndex == 0) {
                var2.setBtn0("X");
                b.setText("X");
            } else if (buttonIndex == 1) {
                var2.setBtn1("X");
                b.setText("X");
            } else if (buttonIndex == 2) {
                var2.setBtn2("X");
                b.setText("X");
            } else {
                var2.setBtn3("X");
                b.setText("X");
            }
        } else {
            if (buttonIndex == 0) {
                var2.setBtn0("0");
                b.setText("0");
            } else if (buttonIndex == 1) {
                var2.setBtn1("0");
                b.setText("0");
            } else if (buttonIndex == 2) {
                var2.setBtn2("0");
                b.setText("0");
            } else {
                var2.setBtn3("0");
                b.setText("0");
            }
        }
        solve();
        // Update the database
        KmapDatabase.getInstance(getApplicationContext()).myDataDao().updateVar2(var2);
    }

    private void solve(){
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
        twoVariablePresenter = new TwoVariablesPresenter(val);
        soln = twoVariablePresenter.getRes();
        // sets the result to text pane
        if (soln.isEmpty()) {
            planeText_SoP.setText(null);
            planeText_PoS.setText(null);
        } else {
            planeText_SoP.setText(soln);
            //planeText_PoS.setText(solver.SoPtoPoSConverter(soln));
            //planeText_grouping.setText(solver.getGroups());
        }
    }
}