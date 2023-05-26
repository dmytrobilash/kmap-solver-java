package com.dmytrobilash.karnaughmap_java.views.drawing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmytrobilash.karnaughmap_java.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrawSchemeActivity extends AppCompatActivity {

    private View lineView;
    private String str;
    boolean schemeFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_scheme);
        FloatingActionButton fab = findViewById(R.id.change);

        LinearLayout layout = findViewById(R.id.painting);
        String type;
        if (extras != null) {
            str = extras.getString("result");
            type = extras.getString("type");
        } else {
            str = "";
            type = "";
        }


        TextView textView = findViewById(R.id.formulae_text);
        textView.setText("F=" + str);

        if(type.equals("PoS")) {
            str = new PoStoSoPConverter().convert(str);
        }

        lineView = new View(this) {
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                @SuppressLint("DrawAllocation") SchemeDrawingUSA schemeDrawing = new SchemeDrawingUSA();
                schemeDrawing.draw(str, canvas, type);
            }
        };
        layout.addView(lineView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.removeAllViews();
                if (schemeFlag) {
                    lineView = new View(getApplicationContext()) {
                        @Override
                        protected void onDraw(Canvas canvas) {
                            super.onDraw(canvas);
                            @SuppressLint("DrawAllocation") SchemeDrawingUSSR schemeDrawing = new SchemeDrawingUSSR();
                            schemeDrawing.draw(str, canvas, type);
                            schemeFlag = false;
                        }
                    };
                } else {
                    lineView = new View(getApplicationContext()) {
                        @Override
                        protected void onDraw(Canvas canvas) {
                            super.onDraw(canvas);
                            @SuppressLint("DrawAllocation") SchemeDrawingUSA schemeDrawing = new SchemeDrawingUSA();
                            schemeDrawing.draw(str, canvas, type);
                            schemeFlag = true;
                        }
                    };
                }
                layout.addView(lineView);
            }
        });

        ImageView share = findViewById(R.id.share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setDrawingCacheEnabled(true);
                layout.buildDrawingCache();
                Bitmap bitmap = layout.getDrawingCache();

                File file = new File(getExternalFilesDir(null), "lineView.png");
                try {

                    FileOutputStream fos = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/png");

                Uri fileUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", file);

                shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.putExtra(Intent.EXTRA_STREAM, fileUri);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "F=" + str);
                startActivity(Intent.createChooser(shareIntent, "Share image"));
            }
        });
    }
}
