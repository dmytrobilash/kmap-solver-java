package com.hfad.karnaughmap_java.views.unions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hfad.karnaughmap_java.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUnionsActivity extends AppCompatActivity {

    private ArrayList<String> unionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_unions);
        Intent currentIntent = getIntent();
        String groups = currentIntent.getStringExtra("Groups");
        String kMap = currentIntent.getStringExtra("kMap");
        groups = groups.replace("]", "] ");
        Log.v("FD",groups);
        String buttonText = currentIntent.getStringExtra("buttonText");
        String [] buttonsText = buttonText.split(" ");
        String[] arr = groups.split(" ");
        unionList = new ArrayList<>();
        unionList.addAll(Arrays.asList(arr));

        RecyclerView recyclerView = findViewById(R.id.rv);
        UnionAdapter adapter = new UnionAdapter(unionList, buttonsText, kMap);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ImageView share = findViewById(R.id.share);



        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Bitmap with the same dimensions as the RecyclerView
                Bitmap bitmap = Bitmap.createBitmap(recyclerView.getWidth(), recyclerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.WHITE);

                recyclerView.draw(canvas);

                File file = new File(getExternalFilesDir(null), "Unions.png");
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

                startActivity(Intent.createChooser(shareIntent, "Share image"));
            }
        });
    }
}