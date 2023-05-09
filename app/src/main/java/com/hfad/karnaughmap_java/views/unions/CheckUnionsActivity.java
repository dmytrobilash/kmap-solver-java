package com.hfad.karnaughmap_java.views.unions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hfad.karnaughmap_java.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUnionsActivity extends AppCompatActivity {

    private ArrayList<String> unionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_unions);
        Intent i = getIntent();
        String groups = i.getStringExtra("Groups");

        String[] arr = groups.split(" ");

        unionList = new ArrayList<>();
        Log.v("Unions", arr[0]);
        Log.v("Unions", arr[1]);
        unionList.add(arr[0]);
        unionList.add(arr[1]);

        // Add more unions as needed
        RecyclerView recyclerView = findViewById(R.id.rv);
        UnionAdapter adapter = new UnionAdapter(unionList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}