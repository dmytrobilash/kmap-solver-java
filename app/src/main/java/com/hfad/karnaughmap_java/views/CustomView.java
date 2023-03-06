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
        int oneTenWidth = width / 10;
        int oneTenHeight = height / 10;
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        String str = "AC+AB+AC+D";

        String[] substrings = str.split("\\+"); // split the string into an array of substrings
        String[] result = new String[substrings.length];

        for (int i = 0; i < substrings.length; i++) {
            result[i] = substrings[i].trim(); // trim each substring and store in new array
        }
        Log.v("AAAA", String.valueOf(result.length));

        int count = 0;
        int rectangleWidth = 200; // 3 times larger than the squareSize
        int rectangleHeight = 300; // 4 times larger than the squareSize
        int spaceSize = 50;

        for (int i = 0; i < result.length; i++) {
            //top
            canvas.drawLine(halfWidth, spaceSize + rectangleHeight * count + spaceSize * i, halfWidth + rectangleWidth, spaceSize + rectangleHeight * count + spaceSize * i, mPaint);
            //bottom
            canvas.drawLine(halfWidth, spaceSize + rectangleHeight + rectangleHeight * count + spaceSize * i, halfWidth + rectangleWidth, spaceSize + rectangleHeight + rectangleHeight * count + spaceSize * i, mPaint);
            //left
            canvas.drawLine(halfWidth, spaceSize + rectangleHeight * count + spaceSize * i, halfWidth, spaceSize + rectangleHeight + rectangleHeight * count + spaceSize * i, mPaint);
            //right
            canvas.drawLine(halfWidth + rectangleWidth, spaceSize + rectangleHeight * count + spaceSize * i, halfWidth + rectangleWidth, spaceSize + rectangleHeight + rectangleHeight * count + spaceSize * i, mPaint);
            count += 2;
        }
        if(str.contains("A")){
            canvas.drawLine(width / 10, 0, width / 10, height, mPaint);
            canvas.drawText("A", width / 10 + 2, 50, mPaint);
        }
        if(str.contains("B")){
            canvas.drawLine(width / 10 * 2, 0, width / 10* 2, height, mPaint);
            canvas.drawText("B", width / 10* 2 + 2, 50, mPaint);
        }
        if(str.contains("C")){
            canvas.drawLine(width / 10 * 3, 0, width / 10 * 3, height, mPaint);
            canvas.drawText("C", width / 10 * 3 + 2, 50, mPaint);
        }
        if(str.contains("D")){
            canvas.drawLine(width / 10 * 4, 0, width / 10* 4, height, mPaint);
            canvas.drawText("D", width / 10 * 4 + 2, 50, mPaint);
        }

    }
}


        /*



        // Draw the vertical lines


        // Draw the horizontal lines


        // Draw the horizontal line
        canvas.drawLine(width / 10, height / 4, width, height / 4, mPaint);
        canvas.drawLine(width / 10 + width / 10, height / 3, width, height / 3, mPaint);
        // Draw the square
        canvas.drawRect(width / 10 * 3, height / 4, width / 10 * 4, height / 3, mPaint);
         */