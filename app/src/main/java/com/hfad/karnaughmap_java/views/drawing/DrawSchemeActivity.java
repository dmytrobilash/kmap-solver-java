package com.hfad.karnaughmap_java.views.drawing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hfad.karnaughmap_java.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrawSchemeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_scheme);
        LinearLayout layout = findViewById(R.id.painting);
        String str;
        if (extras != null) {
            str = extras.getString("result");
        } else {
            str = "";
        }
        TextView textView = findViewById(R.id.formulae_text);
        textView.setText("F=" + str);
        View lineView = new View(this) {
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                @SuppressLint("DrawAllocation") SchemeDrawing schemeDrawing = new SchemeDrawing();
                schemeDrawing.draw(str, canvas);
            }
        };
        layout.addView(lineView);
        lineView.setDrawingCacheEnabled(true);
        ImageView share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Click", "Click");
                Bitmap bitmap = Bitmap.createBitmap(lineView.getDrawingCache());
                File file  = new File(getCacheDir(), "image.jpeg");
                new Thread(() -> {
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(getApplicationContext(), "com.hfad.karnaughmap_java.fileprovider", file));
                //PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, Intent.createChooser(intent, "Share via"), PendingIntent.FLAG_UPDATE_CURRENT);
                Intent chosenIntent = Intent.createChooser(intent, "Via");
                startActivity(chosenIntent);
            }
        });
    }
}
