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

        String str = "A'BC+AD+AB+ABC";

        String[] substrings = str.split("\\+"); // split the string into an array of substrings
        String[] result = new String[substrings.length];

        for (int i = 0; i < substrings.length; i++) {
            result[i] = substrings[i].trim(); // trim each substring and store in new array
        }

        if (str.contains("A")) {
            canvas.drawLine(width / 10, 0, width / 10, height, mPaint);
            canvas.drawText("A", width / 10 + 2, 50, mPaint);
        }
        if (str.contains("B")) {
            canvas.drawLine(width / 10 * 2, 0, width / 10 * 2, height, mPaint);
            canvas.drawText("B", width / 10 * 2 + 2, 50, mPaint);
        }
        if (str.contains("C")) {
            canvas.drawLine(width / 10 * 3, 0, width / 10 * 3, height, mPaint);
            canvas.drawText("C", width / 10 * 3 + 2, 50, mPaint);
        }
        if (str.contains("D")) {
            canvas.drawLine(width / 10 * 4, 0, width / 10 * 4, height, mPaint);
            canvas.drawText("D", width / 10 * 4 + 2, 50, mPaint);
        }

        if (str.contains("A'")){
            //circleA
            canvas.drawCircle(oneTenWidth,oneTenHeight/2, 10, mPaint);
            //line to rect
            canvas.drawLine(oneTenWidth, oneTenHeight/2, oneTenWidth+ oneTenWidth/6, oneTenHeight/2, mPaint);

            //left
            canvas.drawLine(oneTenWidth+oneTenWidth/6, oneTenHeight/3, oneTenWidth+ oneTenWidth/6, oneTenHeight*2/3, mPaint);
            //right

            //top
            canvas.drawLine(oneTenWidth+oneTenWidth/6, oneTenHeight/3, oneTenWidth+ oneTenWidth/3, oneTenHeight/3, mPaint);

            //bottom
            canvas.drawLine(oneTenWidth+oneTenWidth/6, oneTenHeight*2/3,  oneTenWidth+ oneTenWidth/3, oneTenHeight*2/3, mPaint);

            //line from rect
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(oneTenWidth+ oneTenWidth/3, oneTenHeight/2, 8, mPaint);
            canvas.drawLine(oneTenWidth+ oneTenWidth/3, oneTenHeight/2, oneTenWidth+oneTenWidth/2, oneTenHeight/2, mPaint);
            //line from rect to bottom
            canvas.drawLine(oneTenWidth+oneTenWidth/2, oneTenHeight/2, oneTenWidth+oneTenWidth/2, height, mPaint);

        }
        if (str.contains("B'")){

        }
        if (str.contains("C'")){

        }
        if (str.contains("D'")){

        }


    }
}
        /*int count = 0;
        int rectangleWidth = 200; // 3 times larger than the squareSize
        int rectangleHeight = 300; // 4 times larger than the squareSize
        int spaceSize = 50;

        for (int i = 0; i < result.length; i++) {
            //top
            canvas.drawLine(halfWidth, spaceSize + rectangleHeight * count, halfWidth + rectangleWidth, spaceSize + rectangleHeight * count, mPaint);
            //bottom
            canvas.drawLine(halfWidth, spaceSize + rectangleHeight + rectangleHeight * count , halfWidth + rectangleWidth, spaceSize + rectangleHeight + rectangleHeight * count, mPaint);
            //left
            canvas.drawLine(halfWidth, spaceSize + rectangleHeight * count, halfWidth, spaceSize + rectangleHeight + rectangleHeight * count, mPaint);
            //right
            canvas.drawLine(halfWidth + rectangleWidth, spaceSize + rectangleHeight * count, halfWidth + rectangleWidth, spaceSize + rectangleHeight + rectangleHeight * count, mPaint);

            //end and element
            canvas.drawLine(halfWidth + rectangleWidth, spaceSize + rectangleHeight * count + rectangleHeight/2, width-width/4, spaceSize + rectangleHeight * count +rectangleHeight/2, mPaint);

            if(i < result.length/2){
                canvas.drawLine(width-width/4, spaceSize + rectangleHeight * count +rectangleHeight/2,width-width/4, spaceSize + rectangleHeight * count +rectangleHeight/2+rectangleHeight/4*3, mPaint);
                canvas.drawLine(width-width/4,spaceSize + rectangleHeight * count +rectangleHeight/2+rectangleHeight/4*3, width-width/10, spaceSize + rectangleHeight * count +rectangleHeight/2+rectangleHeight/4*3, mPaint );
            }else if(i >= result.length/2){
                canvas.drawLine(width-width/4, spaceSize + rectangleHeight * count +rectangleHeight/2,width-width/4, spaceSize + rectangleHeight * count +rectangleHeight/2-rectangleHeight/4*3, mPaint);
                canvas.drawLine(width-width/4, spaceSize + rectangleHeight * count +rectangleHeight/2-rectangleHeight/4*3, width-width/10,spaceSize + rectangleHeight * count +rectangleHeight/2-rectangleHeight/4*3, mPaint);
            }
            count += 2;
        }

        int spaceInRect = 100;
        int spaceBetweenRect = 0;

        char [] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++){

            if(charArray[i] == 'A'){
                canvas.drawLine(width / 10, spaceInRect + spaceBetweenRect, halfWidth, spaceInRect + spaceBetweenRect, mPaint);
                spaceInRect+=50;
            }
            if( charArray[i] == 'B'){
                canvas.drawLine(width / 10 * 2, spaceInRect + spaceBetweenRect, halfWidth, spaceInRect + spaceBetweenRect, mPaint);
                spaceInRect+=50;
            }
            if(charArray[i] == 'C'){
                canvas.drawLine(width / 10 * 3, spaceInRect + spaceBetweenRect, halfWidth, spaceInRect + spaceBetweenRect, mPaint);
                spaceInRect+=50;

            }
            if(charArray[i] == 'D'){
                canvas.drawLine(width / 10 * 4, spaceInRect + spaceBetweenRect, halfWidth, spaceInRect + spaceBetweenRect, mPaint);
                spaceInRect+=50;
            }
            if(charArray[i] == '+'){
                spaceBetweenRect+=rectangleHeight*2;
            }
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