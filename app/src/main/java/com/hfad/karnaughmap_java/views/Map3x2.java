package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.model.TreeVariables;

public class Map3x2 extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map3x2);
        editText = findViewById(R.id.edit_text);
        int [] arr = new int[8];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 0;
        arr[3] = 0;
        arr[4] = 0;
        arr[5] = 0;
        arr[6] = 0;
        arr[7] = 1;

        editText.setText(new TreeVariables(arr).solve());
    }
}