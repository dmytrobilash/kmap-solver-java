package com.dmytrobilash.karnaughmap_java;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.dmytrobilash.karnaughmap_java.views.InfoActivity;
import com.dmytrobilash.karnaughmap_java.views.Kmap2VariablesActivity;
import com.dmytrobilash.karnaughmap_java.views.Kmap3VariablesActivity;
import com.dmytrobilash.karnaughmap_java.views.Kmap4VariablesActivity;
import com.dmytrobilash.karnaughmap_java.views.Kmap5VariablesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button switchTo2VarActivity = findViewById(R.id.karnaugh_2);
        Button switchTo3VarActivity = findViewById(R.id.karnaugh_3);
        Button switchTo4VarActivity = findViewById(R.id.karnaugh_4);
        Button switchTo5VarActivity = findViewById(R.id.karnaugh_5);
        ImageButton switchToInfoActivity = findViewById(R.id.info);

        setOnClickListenerForActivity(switchTo2VarActivity, Kmap2VariablesActivity.class);
        setOnClickListenerForActivity(switchTo3VarActivity, Kmap3VariablesActivity.class);
        setOnClickListenerForActivity(switchTo4VarActivity, Kmap4VariablesActivity.class);
        setOnClickListenerForActivity(switchTo5VarActivity, Kmap5VariablesActivity.class);
        setOnClickListenerForActivity(switchToInfoActivity, InfoActivity.class);
    }

    private void setOnClickListenerForActivity(View view, final Class<?> activityClass) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainActivity.this, activityClass);
                startActivity(switchActivityIntent);
            }
        });
    }
}