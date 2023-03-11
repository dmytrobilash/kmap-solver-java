package com.hfad.karnaughmap_java.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {
    private Paint mPaint;
    private Paint circlePaint;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(50);
        circlePaint = new Paint();
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
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

        String str = "A'B'C'D'+AB+AC";
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int startMeinVerticalLinesWidth = width / 20;
        int marginTextHorizontal = width / 60;
        int marginTextVertical = height / 40;
        int radius = 7;
        int oneTenHeight = height / 10;
        int oneTenWidth = width / 10;


        String[] substrings = str.split("\\+");

        Log.v("AAA", String.valueOf(substrings.length));


        drawStart(canvas, mPaint, circlePaint, str, startMeinVerticalLinesWidth, height, marginTextHorizontal, marginTextVertical, oneTenHeight, width, oneTenWidth, radius);

        int gap = 40;
        for (int i = 0; i < substrings.length; i++) {
            int count = i + 1;
            int y = count * oneTenHeight + 50 + i*gap; // add i*gap pixels to create a gap between the rectangles
            canvas.drawLine(width / 2, y, width / 2, y + oneTenHeight, mPaint);
            canvas.drawLine(width / 2, y, width / 2 + oneTenWidth, y, mPaint);
            canvas.drawLine(width / 2 + oneTenWidth, y, width / 2 + oneTenWidth, y + oneTenHeight, mPaint);
            canvas.drawLine(width / 2, y + oneTenHeight, width / 2 + oneTenWidth, y + oneTenHeight, mPaint);
        }


    }


    public void drawStart(Canvas canvas, Paint mPaint, Paint circlePaint, String str, int startMeinVerticalLinesWidth, int height, int marginTextHorizontal, int marginTextVertical, int oneTenHeight, int width, int oneTenWidth, int radius) {
        if (str.contains("A")) {
            canvas.drawLine(startMeinVerticalLinesWidth, 0, startMeinVerticalLinesWidth, height, mPaint);
            canvas.drawText("A", startMeinVerticalLinesWidth + marginTextHorizontal, marginTextVertical, mPaint);
            if (str.contains("A'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth, oneTenHeight / 2, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth, oneTenHeight / 2, startMeinVerticalLinesWidth + width / 60, oneTenHeight / 2, mPaint);

                // rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + width / 60, oneTenHeight / 2 + oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2 - oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60, oneTenHeight / 2 + oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2 - radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2 + radius, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                // rect
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100, oneTenHeight / 2, radius, circlePaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + radius, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2, oneTenHeight / 2, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2, height, mPaint);
            }
        }
        if (str.contains("B")) {
            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, 0, startMeinVerticalLinesWidth + oneTenWidth, height, mPaint);
            canvas.drawText("B", startMeinVerticalLinesWidth + marginTextHorizontal + oneTenWidth, marginTextVertical, mPaint);
            if (str.contains("B'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, oneTenHeight / 2, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, oneTenHeight / 2, startMeinVerticalLinesWidth + width / 60 + oneTenWidth, oneTenHeight / 2, mPaint);

                //rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + width / 60 + oneTenWidth, oneTenHeight / 2 + oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2 - oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth, oneTenHeight / 2 + oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2 - radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2 + radius, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                //rect
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth, oneTenHeight / 2, radius, circlePaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + radius + oneTenWidth, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth, oneTenHeight / 2, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth, height, mPaint);
            }
        }

        if (str.contains("C")) {
            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, 0, startMeinVerticalLinesWidth + oneTenWidth * 2, height, mPaint);
            canvas.drawText("C", startMeinVerticalLinesWidth + marginTextHorizontal + oneTenWidth * 2, marginTextVertical, mPaint);
            if (str.contains("C'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, oneTenHeight / 2, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, oneTenHeight / 2, startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 2, oneTenHeight / 2, mPaint);

                //rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 2, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 2, oneTenHeight / 2 + oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 2, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2 - oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 2, oneTenHeight / 2 + oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2 - radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2 + radius, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                //rect
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 2, oneTenHeight / 2, radius, circlePaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + radius + oneTenWidth * 2, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth * 2, oneTenHeight / 2, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth * 2, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth * 2, height, mPaint);
            }
        }
        if (str.contains("D")) {
            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, 0, startMeinVerticalLinesWidth + oneTenWidth * 3, height, mPaint);
            canvas.drawText("D", startMeinVerticalLinesWidth + marginTextHorizontal + oneTenWidth * 3, marginTextVertical, mPaint);
            if (str.contains("D'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, oneTenHeight / 2, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, oneTenHeight / 2, startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 3, oneTenHeight / 2, mPaint);

                //rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 3, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 3, oneTenHeight / 2 + oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 3, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2 - oneTenHeight / 8, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60 + oneTenWidth * 3, oneTenHeight / 2 + oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2 - oneTenHeight / 8, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2 - radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2 + radius, startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2 + oneTenHeight / 8, mPaint);

                //rect
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + oneTenWidth * 3, oneTenHeight / 2, radius, circlePaint);

                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 - width / 100 + radius + oneTenWidth * 3, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth * 3, oneTenHeight / 2, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth * 3, oneTenHeight / 2, startMeinVerticalLinesWidth + oneTenWidth / 2 + oneTenWidth * 3, height, mPaint);
            }
        }
    }
}
