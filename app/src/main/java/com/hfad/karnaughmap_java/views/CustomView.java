package com.hfad.karnaughmap_java.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    private Paint mPaint;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(50);
    }

    public CustomView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        String str = "AC+AB";

        String[] substrings = str.split("\\+"); // split the string into an array of substrings
        String[] result = new String[substrings.length];

        for (int i = 0; i < substrings.length; i++) {
            result[i] = substrings[i].trim(); // trim each substring and store in new array
        }



        /*
        // Draw the vertical lines
        canvas.drawLine(width / 10, 0, width / 10, height, mPaint);
        canvas.drawLine(width / 10 + width / 10, 0, width / 10 + width / 10, height, mPaint);

        // Draw the horizontal lines
        canvas.drawText("A", width / 10, 50, mPaint);
        canvas.drawText("B", width / 10 + width / 10, 50, mPaint);

        // Draw the horizontal line
        canvas.drawLine(width / 10, height / 4, width, height / 4, mPaint);
        canvas.drawLine(width / 10 + width / 10, height / 3, width, height / 3, mPaint);
        // Draw the square
        canvas.drawRect(width / 10 * 3, height / 4, width / 10 * 4, height / 3, mPaint);
         */
    }
}