package com.hfad.karnaughmap_java.views;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hfad.karnaughmap_java.R;

public class MainActivity extends AppCompatActivity  {
    private final Button switchTo2x2Activity = findViewById(R.id.Karnaugh_2x2);
    private final Button switchTo3x2Activity = findViewById(R.id.Karnaugh_3x3);
    private final Button switchTo4x4Activity = findViewById(R.id.Karnaugh_4x4);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListenerFor2x2Activity();
        setOnClickListenerFor3x3Activity();
        setOnClickListenerFor4x4Activity();
    }

    private void setOnClickListenerFor2x2Activity() {
        switchTo2x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(getApplicationContext(), Map2x2.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    private void setOnClickListenerFor3x3Activity() {
        switchTo3x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(getApplicationContext(), Map3x2.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    private void setOnClickListenerFor4x4Activity() {
        switchTo4x4Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(getApplicationContext(), Map4x4.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}