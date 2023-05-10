package com.hfad.karnaughmap_java.views.unions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
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
        groups = groups.replace("]", "] ");
        Log.v("FD",groups);
        String buttonText = currentIntent.getStringExtra("buttonText");
        String [] buttonsText = buttonText.split(" ");
        String[] arr = groups.split(" ");
        unionList = new ArrayList<>();
        unionList.addAll(Arrays.asList(arr));

        RecyclerView recyclerView = findViewById(R.id.rv);
        UnionAdapter adapter = new UnionAdapter(unionList, buttonsText);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ImageView share = findViewById(R.id.share);
    }
}