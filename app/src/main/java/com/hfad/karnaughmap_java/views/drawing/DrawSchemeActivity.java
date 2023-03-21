package com.hfad.karnaughmap_java.views.drawing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hfad.karnaughmap_java.R;

import java.io.ByteArrayOutputStream;
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


        ImageView share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineView.setDrawingCacheEnabled(true);
                lineView.buildDrawingCache();



                /*File file = new File(getCacheDir(), "image.jpeg");
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, file);
                startActivity(Intent.createChooser(intent, "Send Image"));

                Bitmap bitmap = Bitmap.createBitmap(lineView.getDrawingCache());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/png");

// Use ClipData to add the image URI to the Intent
                Uri imageUri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null));
                ClipData clipData = ClipData.newUri(getContentResolver(), "image", imageUri);
                intent.setClipData(clipData);
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);

                startActivity(Intent.createChooser(intent, "Send Image"));*/
            }
        });
    }
}
