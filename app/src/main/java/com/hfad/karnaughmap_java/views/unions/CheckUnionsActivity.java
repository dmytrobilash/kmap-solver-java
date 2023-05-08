package com.hfad.karnaughmap_java.views.unions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hfad.karnaughmap_java.R;

import java.util.ArrayList;

public class CheckUnionsActivity extends AppCompatActivity {
    private ArrayList<String> unionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_unions);

        unionList = new ArrayList<>();

        unionList.add("Union 1");
        unionList.add("Union 2");
        unionList.add("Union 3");
        // Add more unions as needed
        RecyclerView recyclerView = findViewById(R.id.rv);
        UnionAdapter adapter = new UnionAdapter(unionList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}