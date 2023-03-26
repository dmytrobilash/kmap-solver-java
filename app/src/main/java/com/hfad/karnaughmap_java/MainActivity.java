package com.hfad.karnaughmap_java;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hfad.karnaughmap_java.views.Map2x2;
import com.hfad.karnaughmap_java.views.Map3x2;
import com.hfad.karnaughmap_java.views.Map4x4;

public class MainActivity extends AppCompatActivity  {
    private  Button switchTo2x2Activity;
    private  Button switchTo3x2Activity;
    private  Button switchTo4x4Activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        switchTo2x2Activity = findViewById(R.id.Karnaugh_2x2);
        switchTo3x2Activity = findViewById(R.id.Karnaugh_3x3);
        switchTo4x4Activity = findViewById(R.id.Karnaugh_4x4);
        setOnClickListenerFor2x2Activity();
        setOnClickListenerFor3x3Activity();
        setOnClickListenerFor4x4Activity();
    }

    private void setOnClickListenerFor2x2Activity() {
        switchTo2x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainActivity.this, Map2x2.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    private void setOnClickListenerFor3x3Activity() {
        switchTo3x2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainActivity.this, Map3x2.class);
                startActivity(switchActivityIntent);
            }
        });
    }

    private void setOnClickListenerFor4x4Activity() {
        switchTo4x4Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainActivity.this, Map4x4.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}