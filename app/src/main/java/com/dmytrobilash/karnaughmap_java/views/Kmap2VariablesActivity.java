package com.dmytrobilash.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
        import android.widget.EditText;
import android.widget.TextView;

import com.dmytrobilash.karnaughmap_java.Presenter.TwoVariablesPresenter;
import com.dmytrobilash.karnaughmap_java.R;
import com.dmytrobilash.karnaughmap_java.model.db.KmapDatabase;
import com.dmytrobilash.karnaughmap_java.model.db.Var2;
import com.dmytrobilash.karnaughmap_java.views.drawing.DrawSchemeActivity;
import com.dmytrobilash.karnaughmap_java.views.unions.CheckUnionsActivity;

import java.util.Arrays;

public class Kmap2VariablesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons;
    private TwoVariablesPresenter twoVariablePresenter;
    private EditText result;
    private Boolean formFlag = true; //means SoP was created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmap2_variables);

        buttons = new Button[]{findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3)};
        result = findViewById(R.id.result);
        twoVariablePresenter = new TwoVariablesPresenter(buttons, getApplicationContext());
        twoVariablePresenter.initButtonsValues(buttons, result);
        solve();
        Button scheme = findViewById(R.id.scheme);
        Button unions = findViewById(R.id.unions);
        Button set0 = findViewById(R.id.set0), set1 = findViewById(R.id.set1);
        Button changeForm = findViewById(R.id.change_form);
        ;
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }

        changeForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(formFlag){
                    changeForm.setText("SoP");
                    formFlag = false;
                }else{
                    changeForm.setText("PoS");
                    formFlag = true;
                }
                solve();
            }
        });
        scheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Kmap2VariablesActivity.this, DrawSchemeActivity.class);
                if(formFlag){
                    switchActivityIntent.putExtra("type", "SoP");
                }else{
                    switchActivityIntent.putExtra("type", "PoS");
                }
                switchActivityIntent.putExtra("result", String.valueOf(result.getText()));
                startActivity(switchActivityIntent);
            }
        });

        unions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = "";
                for (Button button : buttons) {
                    buttonText += button.getText() + " ";
                }
                int[] val;
                String groups;
                val = new int[4];

                for (int i = 0; i < val.length; i++) {
                    if (buttons[i].getText().toString().matches("X")) {
                        val[i] = 2;
                    } else {
                        val[i] = Integer.parseInt(buttons[i].getText().toString());
                    }
                }

                twoVariablePresenter = new TwoVariablesPresenter(buttons, getApplicationContext());

                if(formFlag){
                    groups = twoVariablePresenter.getGroupsSoP();
                }
                else{
                    groups = twoVariablePresenter.getGroupsPoS();
                }
                Intent switchActivityIntent = new Intent(Kmap2VariablesActivity.this, CheckUnionsActivity.class);
                switchActivityIntent.putExtra("kMap", "2");
                switchActivityIntent.putExtra("buttonText", buttonText);
                switchActivityIntent.putExtra("Groups", groups);
                startActivity(switchActivityIntent);
            }
        });

        set0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Button button : buttons) {
                    button.setText("0");
                }
                twoVariablePresenter.set0();
                solve();
            }
        });

        set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Button button : buttons) {
                    button.setText("1");
                }
                twoVariablePresenter.set1();
                solve();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        twoVariablePresenter.updateButtonValues(b);
        solve();
    }

    private void solve(){
        if(formFlag){
            result.setText(twoVariablePresenter.getResSoP());
        }else{
            result.setText(twoVariablePresenter.getResPoS());
        }
    }
}