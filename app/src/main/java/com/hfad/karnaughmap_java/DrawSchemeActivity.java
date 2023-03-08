package com.hfad.karnaughmap_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DrawSchemeActivity extends AppCompatActivity {

    Paint paint = new Paint();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String myExtra = intent.getStringExtra("result");
        Toast.makeText(this, myExtra, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_sceme);

        paint.setColor(Color.RED); // Set line color
        paint.setStrokeWidth(5); // Set line width

    }
}