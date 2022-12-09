package com.hfad.karnaughmap_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;

public class Map2x2SchemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2x2_scheme);
        DrawLine drawLine = new DrawLine(this);

        drawLine.setBackgroundColor(Color.LTGRAY);

        setContentView(drawLine);
    }
}