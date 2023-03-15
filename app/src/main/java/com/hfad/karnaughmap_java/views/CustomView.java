package com.hfad.karnaughmap_java.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.stream.Collectors;

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

        String str = "AB+BB+CB'+AC";
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int startMeinVerticalLinesWidth = width / 20;
        int marginTextHorizontal = width / 80;
        int marginTextVertical = height / 40;
        int radius = 7;
        int oneTenHeight = height / 10;
        int oneTenWidth = width / 10;


        String[] substrings = str.split("\\+");

        Log.v("AAA", String.valueOf(substrings.length));


        drawStart(canvas, mPaint, circlePaint, str, startMeinVerticalLinesWidth, height, marginTextHorizontal, marginTextVertical, oneTenHeight, width, oneTenWidth, radius);

        int gap = height/100;

        for (int i = 0; i < substrings.length; i++) {
            for (int j = 0; j < substrings[i].length(); j++) {
                String withoutNor = substrings[i].chars().filter(c -> c != '\'').mapToObj(c -> Character.toString((char) c))
                        .collect(Collectors.joining());

                int count = i + 1;
                float lineSpacing = (oneTenHeight - oneTenHeight / 4) / (substrings.length - 1);
                int difference = width / 60;
                int y = count * oneTenHeight + i * gap; // add i*gap pixels to create a gap between the rectangles
                if (withoutNor.length() != 1) {

                    canvas.drawLine(width / 2, y, width / 2, y + oneTenHeight, mPaint);
                    canvas.drawLine(width / 2, y, width / 2 + oneTenWidth, y, mPaint);
                    canvas.drawLine(width / 2 + oneTenWidth, y, width / 2 + oneTenWidth, y + oneTenHeight, mPaint);
                    canvas.drawLine(width / 2, y + oneTenHeight, width / 2 + oneTenWidth, y + oneTenHeight, mPaint);

                    if (substrings.length % 2 == 0) {
                        if (i < substrings.length / 2) {
                            canvas.drawLine(width / 2 + oneTenWidth, y + oneTenHeight / 2, width / 2 + oneTenWidth * 2 - difference * i, y + oneTenHeight / 2, mPaint);
                            canvas.drawLine(width / 2 + oneTenWidth * 2 - difference * i, y + oneTenHeight / 2, width / 2 + oneTenWidth * 2 - difference * i, (oneTenHeight + substrings.length * oneTenHeight + (substrings.length - 1) * gap) / 2 + oneTenHeight / 2 - lineSpacing * (substrings.length/2-i)+gap/2, mPaint);
                        } else {
                            canvas.drawLine(width / 2 + oneTenWidth, y + oneTenHeight / 2, width / 2 + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i), y + oneTenHeight / 2, mPaint);
                            canvas.drawLine(width / 2 + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i), y + oneTenHeight / 2, width / 2 + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i), (oneTenHeight + substrings.length * oneTenHeight + (substrings.length - 1) * gap) / 2 + oneTenHeight / 2 - lineSpacing * (substrings.length/2-i)+gap/2, mPaint);
                        }
                    } else {
                        //todo
                    }
                }

                if (withoutNor.length() == 1) {
                    if (substrings[i].contains("A")) {
                        if (substrings[i].contains("A'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        }
                    }
                    if (substrings[i].contains("B")) {
                        if (substrings[i].contains("B'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        }
                    }
                    if (substrings[i].contains("C")) {
                        if (substrings[i].contains("C'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        }
                    }
                    if (substrings[i].contains("D")) {
                        if (substrings[i].contains("D'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 2, width / 2 + oneTenWidth, y + oneTenHeight / 2, mPaint);
                        }
                    }
                }

                if (withoutNor.length() == 2) {
                    int line = 0;
                    if (substrings[i].contains("A")) {
                        if (substrings[i].contains("A'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                            line++;
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 5, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                            line++;
                        }
                    }

                    if (substrings[i].contains("B")) {
                        if (line == 0) {
                            if (substrings[i].contains("B'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            }
                        } else {
                            if (substrings[i].contains("B'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            }

                        }
                    }
                    if (substrings[i].contains("C")) {
                        if (line == 0) {
                            if (substrings[i].contains("C'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            }

                        } else {
                            if (substrings[i].contains("C'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            }
                        }
                    }
                    if (substrings[i].contains("D")) {
                        if (line == 0) {
                            if (substrings[i].contains("D'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            }

                        } else {
                            if (substrings[i].contains("D'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            }
                        }
                    }
                }

                if (withoutNor.length() == 3) {

                    int line = 0;
                    if (substrings[i].contains("A")) {
                        if (substrings[i].contains("A'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                            line++;
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 5, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                            line++;
                        }
                    }

                    if (substrings[i].contains("B")) {
                        if (line == 0) {
                            if (substrings[i].contains("B'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            }
                        } else {
                            if (substrings[i].contains("B'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 2, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 2, width / 2, y + oneTenHeight - oneTenHeight / 2, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 2, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 2, width / 2, y + oneTenHeight - oneTenHeight / 2, mPaint);
                                line++;
                            }
                        }
                    }
                    if (substrings[i].contains("C")) {
                        if (line == 0) {
                            if (substrings[i].contains("C'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            }

                        } else if (line == 1) {
                            if (substrings[i].contains("C'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 2, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 2, width / 2, y + oneTenHeight - oneTenHeight / 2, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 2, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 2, width / 2, y + oneTenHeight - oneTenHeight / 2, mPaint);
                                line++;
                            }
                        } else {
                            if (substrings[i].contains("C'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            }
                        }
                    }
                    if (substrings[i].contains("D")) {
                        if (line == 0) {
                            if (substrings[i].contains("D'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                                line++;
                            }

                        } else if (line == 1) {
                            if (substrings[i].contains("D'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 2, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 2, width / 2, y + oneTenHeight - oneTenHeight / 2, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 2, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 2, width / 2, y + oneTenHeight - oneTenHeight / 2, mPaint);
                                line++;
                            }
                        } else {
                            if (substrings[i].contains("D'")) {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            } else {
                                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5, radius, mPaint);
                                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5, width / 2, y + oneTenHeight - oneTenHeight / 5, mPaint);
                                line++;
                            }
                        }
                    }
                }

                if (withoutNor.length() == 4) {

                    if (substrings[i].contains("A")) {
                        if (substrings[i].contains("A'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 5, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 5, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 5, width / 2, y + oneTenHeight / 5, mPaint);
                        }
                    }

                    if (substrings[i].contains("B")) {
                        if (substrings[i].contains("B'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 5 * 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2, y + oneTenHeight / 5 * 2, width / 2, y + oneTenHeight / 5 * 2, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5 * 2, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5 * 2, width / 2, y + oneTenHeight / 5 * 2, mPaint);
                        }
                    }
                    if (substrings[i].contains("C")) {

                        if (substrings[i].contains("C'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 5 * 3, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2, y + oneTenHeight / 5 * 3, width / 2, y + oneTenHeight / 5 * 3, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5 * 3, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5 * 3, width / 2, y + oneTenHeight / 5 * 3, mPaint);
                        }
                    }

                    if (substrings[i].contains("D")) {
                        if (substrings[i].contains("D'")) {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 5 * 4, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2, y + oneTenHeight / 5 * 4, width / 2, y + oneTenHeight / 5 * 4, mPaint);
                        } else {
                            canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5 * 4, radius, mPaint);
                            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5 * 4, width / 2, y + oneTenHeight / 5 * 4, mPaint);

                        }
                    }
                }
            }

        }

        //end
        int difference = width/60;
        int y = (oneTenHeight + substrings.length*oneTenHeight + (substrings.length-1)*gap)/2;
        int xStart = width / 2 + width/4;
        canvas.drawLine(xStart, y, xStart, y + oneTenHeight, mPaint);
        canvas.drawLine(xStart, y, xStart + oneTenWidth, y, mPaint);
        canvas.drawLine(xStart + oneTenWidth, y, xStart + oneTenWidth, y + oneTenHeight, mPaint);
        canvas.drawLine(xStart, y + oneTenHeight, xStart + oneTenWidth, y + oneTenHeight, mPaint);
        canvas.drawLine(xStart + oneTenWidth, y + oneTenHeight/2, width, y + oneTenHeight/2, mPaint);

        float lineSpacing = (oneTenHeight - oneTenHeight/4) / (substrings.length - 1);

        for(int i = 0; i < substrings.length;i++) {
            if (substrings.length % 2 == 0) {

                if (i < substrings.length / 2) {
                    canvas.drawLine(width / 2 + oneTenWidth * 2 - difference * i, y + oneTenHeight / 8 + lineSpacing * i, xStart, y + oneTenHeight / 8 + lineSpacing * i, mPaint);
                } else {
                    canvas.drawLine(width / 2 + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i), y + oneTenHeight / 8 + lineSpacing * i, xStart, y + oneTenHeight / 8 + lineSpacing * i, mPaint);
                }
            } else {
                canvas.drawLine(width / 2 + oneTenWidth * 2, y + oneTenHeight / 8 + lineSpacing * i, xStart, y + oneTenHeight / 8 + lineSpacing * i, mPaint);
            }
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
