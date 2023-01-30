package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hfad.karnaughmap_java.R;

public class MainActivity extends AppCompatActivity {
    Button switchTo2x2Activity;
    Button switchTo3x2Activity;
    Button switchTo4x4Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchTo2x2Activity = findViewById(R.id.Karnaugh_2x2);
        switchTo2x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });

        switchTo3x2Activity = findViewById(R.id.Karnaugh_3x3);
        switchTo2x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
        switchTo2x2Activity = findViewById(R.id.Karnaugh_4x4);
        switchTo2x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, map2x2.class);
        startActivity(switchActivityIntent);
    }
}