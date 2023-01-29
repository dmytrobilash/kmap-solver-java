package com.hfad.karnaughmap_java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawUnions extends View {
    Paint paint = new Paint();

    public DrawUnions(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(500);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawLine(212, 100, 1500, 1500, paint);
    }
}
