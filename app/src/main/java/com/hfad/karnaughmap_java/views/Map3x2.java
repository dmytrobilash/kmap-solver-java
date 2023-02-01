package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.solvers.Map3x2_solver;

public class Map3x2 extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map3x2);
        editText = findViewById(R.id.edit_text);
        int [] arr = new int[8];
        for(int i = 0; i < 7; i++){
            arr[i] = 1;
            arr[7] = 0;
        }
        editText.setText(new Map3x2_solver(arr).solve());
    }
}