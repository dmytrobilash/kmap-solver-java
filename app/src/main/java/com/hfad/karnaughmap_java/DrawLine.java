package com.hfad.karnaughmap_java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawLine extends View {
    Paint paint = new Paint();
    public DrawLine(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setTextSize(50);
    }

    @Override
    public void onDraw(Canvas canvas) {
        String text = "ABCD";
        char[] text_char = text.toCharArray();
        for(int i = 0; i < 4; i++){
            canvas.drawLine(20+(i*100), 20, 20+(i*100), 1400, paint);
            canvas.drawLine(20+(i*100), 100, 60+(i*100), 100, paint);
            canvas.drawLine(60+(i*100), 100, 60+(i*100), 1400, paint);
            canvas.drawText(String.valueOf(text_char[i]), 30+(i*100), 50, paint);
        }
    }
}
