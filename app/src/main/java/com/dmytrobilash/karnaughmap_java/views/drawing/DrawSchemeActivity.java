package com.dmytrobilash.karnaughmap_java.views.drawing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dmytrobilash.karnaughmap_java.R;

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
        if(type.equals("PoS")){
            char [] chars = str.toCharArray();
            str = "";
            for(int i = 0; i < chars.length; i++){
                if(chars[i] == ')' || chars[i] == '(');
                else if(chars[i] == 'A' && chars[i+1] !='\''){
                    str+="A'";
                }
                else if(chars[i] == 'B' && chars[i+1] !='\''){
                    str+="B'";
                }
                else if(chars[i] == 'C' && chars[i+1] !='\''){
                    str+="C'";
                }
                else if(chars[i] == 'D' && chars[i+1] !='\''){
                    str+="D'";
                }
                else if(chars[i] == '+');
                else if(chars[i] == '*'){
                    str+="+";
                }
                else if(chars[i] == 'A' && chars[i+1] =='\''){
                    str+="A";
                }
                else if(chars[i] == 'B' && chars[i+1] =='\''){
                    str+="B";
                }
                else if(chars[i] == 'C' && chars[i+1] =='\''){
                    str+="C";
                }
                else if(chars[i] == 'D' && chars[i+1] =='\''){
                    str+="D";
                }
            }
            Log.v("STRING", str);
        }
        String finalStr = str;
        View lineView = new View(this) {
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                @SuppressLint("DrawAllocation")
                SchemeDrawingUSA schemeDrawing = new SchemeDrawingUSA();
                schemeDrawing.draw(finalStr, canvas, type);
            }
        };
        layout.addView(lineView);


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
                    //Toast.makeText(getApplicationContext(), "Image saved to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/png");

                Uri fileUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", file);

                shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.putExtra(Intent.EXTRA_STREAM, fileUri);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "F=" + finalStr);
                startActivity(Intent.createChooser(shareIntent, "Share image"));
            }
        });
    }
}
