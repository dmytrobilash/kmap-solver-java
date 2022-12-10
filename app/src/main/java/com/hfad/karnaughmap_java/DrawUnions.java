package com.hfad.karnaughmap_java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawUnions extends View {
    Paint paint = new Paint();

    public DrawUnions(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
    }

    @Override
    public void onDraw(Canvas canvas) {

    }
}
