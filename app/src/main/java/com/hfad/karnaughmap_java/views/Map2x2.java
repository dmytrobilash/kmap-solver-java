package com.hfad.karnaughmap_java.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hfad.karnaughmap_java.R;
import com.hfad.karnaughmap_java.model.db.Dao;
import com.hfad.karnaughmap_java.model.db.KmapDatabase;
import com.hfad.karnaughmap_java.model.db.Realization;

public class Map2x2 extends AppCompatActivity implements View.OnClickListener {

    private Button[] buttons;
    private EditText planeText_SoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2x2);
        KmapDatabase db = KmapDatabase.getDatabase(getApplicationContext());
        Dao dao = db.table2Dao();
        Realization realization = new Realization(dao);
        realization.setButton("1111", () -> {
            runOnUiThread(() -> {
                Toast.makeText(this, "Button value saved", Toast.LENGTH_SHORT).show();
                String value = realization.getButton();
                Log.v("1", value);
            });
        });

    }

    @Override
    public void onClick(View view) {

    }
}
