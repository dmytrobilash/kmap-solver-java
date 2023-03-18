package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.SchemeDrawing;

import java.util.stream.Collectors;

public class DrawSchemeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_scheme);
        LinearLayout layout = findViewById(R.id.painting);

        View lineView = new View(this) {
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                @SuppressLint("DrawAllocation") SchemeDrawing schemeDrawing = new SchemeDrawing();
                String str;
                if (extras != null) {
                    str = extras.getString("result");
                    // Use myValue as needed
                } else {
                    str = "AA";
                }
                schemeDrawing.draw(str, canvas);

            }
        };
        layout.addView(lineView);
    }
}
