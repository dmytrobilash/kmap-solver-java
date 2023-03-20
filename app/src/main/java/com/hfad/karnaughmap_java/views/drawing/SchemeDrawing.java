package com.hfad.karnaughmap_java.views.drawing;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.stream.Collectors;

public class SchemeDrawing {

    private Paint mPaint;

    public void draw(String str, Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int startMeinVerticalLinesWidth = width / 20;
        int marginTextHorizontal = width / 80;
        int marginTextVertical = height / 40;
        int radius = 10;
        int oneTenHeight = height / 10;
        int oneTenWidth = width / 10;
        int gap = height / 100;
        String[] substrings = str.split("\\+");
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(50);
        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
        if (!str.isEmpty()) {
            drawStart(canvas, mPaint, circlePaint, str, startMeinVerticalLinesWidth, height, marginTextHorizontal, marginTextVertical, oneTenHeight, width, oneTenWidth, radius);
            drawEndRect(canvas, width, oneTenHeight, oneTenWidth, gap, substrings, mPaint);

            for (int i = 0; i < substrings.length; i++) {
                for (int j = 0; j < substrings[i].length(); j++) {
                    String withoutNor = substrings[i].chars().filter(c -> c != '\'').mapToObj(c -> Character.toString((char) c))
                            .collect(Collectors.joining());
                    int count = i + 1;
                    float lineSpacing = (substrings.length - 1 != 0) ? (oneTenHeight - oneTenHeight / 4f) / (substrings.length - 1) : (oneTenHeight - oneTenHeight / 4f);
                    int difference = width / 60;
                    int y = count * oneTenHeight + i * gap;
                    drawStartToMiddleConnectivity(canvas, i, startMeinVerticalLinesWidth, radius, y, withoutNor, width, oneTenHeight, oneTenWidth, substrings);
                    drawMiddleRect(canvas, i, difference, lineSpacing, gap, y, withoutNor, width, oneTenHeight, oneTenWidth, substrings);
                }
            }
        }
    }

    private void drawStart(Canvas canvas, Paint mPaint, Paint circlePaint, String str, int startMeinVerticalLinesWidth, int height, int marginTextHorizontal, int marginTextVertical, int oneTenHeight, int width, int oneTenWidth, int radius) {
        float stopNorX = startMeinVerticalLinesWidth + oneTenWidth / 2f - width / 100f;

        if (str.contains("A")) {
            canvas.drawLine(startMeinVerticalLinesWidth, 0, startMeinVerticalLinesWidth, height, mPaint);
            canvas.drawText("A", startMeinVerticalLinesWidth + marginTextHorizontal, marginTextVertical, mPaint);
            if (str.contains("A'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth, oneTenHeight / 2f, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth, oneTenHeight / 2f, startMeinVerticalLinesWidth + width / 60f, oneTenHeight / 2f, mPaint);

                // rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f, oneTenHeight / 2f - oneTenHeight / 8f, startMeinVerticalLinesWidth + width / 60f, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX, oneTenHeight / 2f - oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f, oneTenHeight / 2f + oneTenHeight / 8f, stopNorX, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);

                canvas.drawLine(stopNorX, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX, oneTenHeight / 2f - radius, mPaint);
                canvas.drawLine(stopNorX, oneTenHeight / 2f + radius, stopNorX, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);

                // rect
                canvas.drawCircle(stopNorX, oneTenHeight / 2f, radius, circlePaint);

                canvas.drawLine(stopNorX + radius, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f, oneTenHeight / 2f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f, height, mPaint);
            }
        }

        if (str.contains("B")) {
            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, 0, startMeinVerticalLinesWidth + oneTenWidth, height, mPaint);
            canvas.drawText("B", startMeinVerticalLinesWidth + marginTextHorizontal + oneTenWidth, marginTextVertical, mPaint);
            if (str.contains("B'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, oneTenHeight / 2f, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, oneTenHeight / 2f, startMeinVerticalLinesWidth + width / 60f + oneTenWidth, oneTenHeight / 2f, mPaint);

                //rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth, oneTenHeight / 2f - oneTenHeight / 8f, startMeinVerticalLinesWidth + width / 60f + oneTenWidth, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX + oneTenWidth, oneTenHeight / 2f - oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth, oneTenHeight / 2f + oneTenHeight / 8f, stopNorX + oneTenWidth, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);

                canvas.drawLine(stopNorX + oneTenWidth, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX + oneTenWidth, oneTenHeight / 2f - radius, mPaint);
                canvas.drawLine(stopNorX + oneTenWidth, oneTenHeight / 2f + radius, stopNorX + oneTenWidth, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);

                //rect
                canvas.drawCircle(stopNorX + oneTenWidth, oneTenHeight / 2f, radius, circlePaint);

                canvas.drawLine(stopNorX + radius + oneTenWidth, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth, oneTenHeight / 2f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth, height, mPaint);
            }
        }

        if (str.contains("C")) {
            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, 0, startMeinVerticalLinesWidth + oneTenWidth * 2, height, mPaint);
            canvas.drawText("C", startMeinVerticalLinesWidth + marginTextHorizontal + oneTenWidth * 2, marginTextVertical, mPaint);
            if (str.contains("C'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, oneTenHeight / 2f, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, oneTenHeight / 2f, startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 2, oneTenHeight / 2f, mPaint);

                //rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 2, oneTenHeight / 2f - oneTenHeight / 8f, startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 2, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 2, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX + oneTenWidth * 2, oneTenHeight / 2f - oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 2, oneTenHeight / 2f + oneTenHeight / 8f, stopNorX + oneTenWidth * 2, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                canvas.drawLine(stopNorX + oneTenWidth * 2, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX + oneTenWidth * 2, oneTenHeight / 2f - radius, mPaint);
                canvas.drawLine(stopNorX + oneTenWidth * 2, oneTenHeight / 2f + radius, stopNorX + oneTenWidth * 2, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                //rect

                canvas.drawCircle(stopNorX + oneTenWidth * 2, oneTenHeight / 2f, radius, circlePaint);

                canvas.drawLine(stopNorX + radius + oneTenWidth * 2, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth * 2, oneTenHeight / 2f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth * 2, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth * 2, height, mPaint);
            }
        }

        if (str.contains("D")) {
            canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, 0, startMeinVerticalLinesWidth + oneTenWidth * 3, height, mPaint);
            canvas.drawText("D", startMeinVerticalLinesWidth + marginTextHorizontal + oneTenWidth * 3, marginTextVertical, mPaint);
            if (str.contains("D'")) {
                canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, oneTenHeight / 2f, radius, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, oneTenHeight / 2f, startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 3, oneTenHeight / 2f, mPaint);

                //rect
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 3, oneTenHeight / 2f - oneTenHeight / 8f, startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 3, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 3, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX + oneTenWidth * 3, oneTenHeight / 2f - oneTenHeight / 8f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + width / 60f + oneTenWidth * 3, oneTenHeight / 2f + oneTenHeight / 8f, stopNorX + oneTenWidth * 3, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);
                canvas.drawLine(stopNorX + oneTenWidth * 3, oneTenHeight / 2f - oneTenHeight / 8f, stopNorX + oneTenWidth * 3, oneTenHeight / 2f - radius, mPaint);
                canvas.drawLine(stopNorX + oneTenWidth * 3, oneTenHeight / 2f + radius, stopNorX + oneTenWidth * 3, oneTenHeight / 2f + oneTenHeight / 8f, mPaint);

                //rect
                canvas.drawCircle(stopNorX + oneTenWidth * 3, oneTenHeight / 2f, radius, circlePaint);

                canvas.drawLine(stopNorX + radius + oneTenWidth * 3, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth * 3, oneTenHeight / 2f, mPaint);
                canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth * 3, oneTenHeight / 2f, startMeinVerticalLinesWidth + oneTenWidth / 2f + oneTenWidth * 3, height, mPaint);
            }
        }
    }

    private void drawStartToMiddleConnectivity(Canvas canvas, int i, int startMeinVerticalLinesWidth, int radius, int y, String withoutNor, int width, int oneTenHeight, int oneTenWidth, String[] substrings) {
        if (withoutNor.length() == 1) {
            if (substrings[i].contains("A")) {
                if (substrings[i].contains("A'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                }
            }
            if (substrings[i].contains("B")) {
                if (substrings[i].contains("B'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                }
            }
            if (substrings[i].contains("C")) {
                if (substrings[i].contains("C'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                }
            }
            if (substrings[i].contains("D")) {
                if (substrings[i].contains("D'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 2f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 2f, width / 2f + oneTenWidth, y + oneTenHeight / 2f, mPaint);
                }
            }
        }

        if (withoutNor.length() == 2) {
            int line = 0;
            if (substrings[i].contains("A")) {
                if (substrings[i].contains("A'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 5f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                }
                line++;
            }

            if (substrings[i].contains("B")) {
                if (line == 0) {
                    if (substrings[i].contains("B'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    }
                } else {
                    if (substrings[i].contains("B'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    }

                }
                line++;
            }
            if (substrings[i].contains("C")) {
                if (line == 0) {
                    if (substrings[i].contains("C'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    }

                } else {
                    if (substrings[i].contains("C'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    }
                }
                line++;
            }
            if (substrings[i].contains("D")) {
                if (line == 0) {
                    if (substrings[i].contains("D'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    }
                } else {
                    if (substrings[i].contains("D'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    }
                }
            }
        }

        if (withoutNor.length() == 3) {

            int line = 0;
            if (substrings[i].contains("A")) {
                if (substrings[i].contains("A'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 5f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                }
                line++;
            }

            if (substrings[i].contains("B")) {
                if (line == 0) {
                    if (substrings[i].contains("B'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    }
                } else {
                    if (substrings[i].contains("B'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 2f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 2f, width / 2f, y + oneTenHeight - oneTenHeight / 2f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 2f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight - oneTenHeight / 2f, width / 2f, y + oneTenHeight - oneTenHeight / 2f, mPaint);
                    }
                }
                line++;
            }
            if (substrings[i].contains("C")) {
                if (line == 0) {
                    if (substrings[i].contains("C'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    }
                    line++;

                } else if (line == 1) {
                    if (substrings[i].contains("C'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 2f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 2f, width / 2f, y + oneTenHeight - oneTenHeight / 2f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 2f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 2f, width / 2f, y + oneTenHeight - oneTenHeight / 2f, mPaint);
                    }
                    line++;
                } else {
                    if (substrings[i].contains("C'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    }
                    line++;
                }
            }
            if (substrings[i].contains("D")) {
                if (line == 0) {
                    if (substrings[i].contains("D'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                    }

                } else if (line == 1) {
                    if (substrings[i].contains("D'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 2f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 2f, width / 2f, y + oneTenHeight - oneTenHeight / 2f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 2f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 2f, width / 2f, y + oneTenHeight - oneTenHeight / 2f, mPaint);
                    }
                } else {
                    if (substrings[i].contains("D'")) {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5f, radius, mPaint);
                        canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight - oneTenHeight / 5f, width / 2f, y + oneTenHeight - oneTenHeight / 5f, mPaint);
                    }
                }
            }
        }

        if (withoutNor.length() == 4) {

            if (substrings[i].contains("A")) {
                if (substrings[i].contains("A'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth / 2f, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth, y + oneTenHeight / 5f, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth, y + oneTenHeight / 5f, width / 2f, y + oneTenHeight / 5f, mPaint);
                }
            }

            if (substrings[i].contains("B")) {
                if (substrings[i].contains("B'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 5f * 2, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth + oneTenWidth / 2f, y + oneTenHeight / 5f * 2, width / 2f, y + oneTenHeight / 5f * 2, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5f * 2, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth, y + oneTenHeight / 5f * 2, width / 2f, y + oneTenHeight / 5f * 2, mPaint);
                }
            }
            if (substrings[i].contains("C")) {

                if (substrings[i].contains("C'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 5f * 3, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2 + oneTenWidth / 2f, y + oneTenHeight / 5f * 3, width / 2f, y + oneTenHeight / 5f * 3, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5f * 3, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 2, y + oneTenHeight / 5f * 3, width / 2f, y + oneTenHeight / 5f * 3, mPaint);
                }
            }

            if (substrings[i].contains("D")) {
                if (substrings[i].contains("D'")) {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 5f * 4, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3 + oneTenWidth / 2f, y + oneTenHeight / 5f * 4, width / 2f, y + oneTenHeight / 5f * 4, mPaint);
                } else {
                    canvas.drawCircle(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5f * 4, radius, mPaint);
                    canvas.drawLine(startMeinVerticalLinesWidth + oneTenWidth * 3, y + oneTenHeight / 5f * 4, width / 2f, y + oneTenHeight / 5f * 4, mPaint);

                }
            }
        }
    }

    private void drawMiddleRect(Canvas canvas, int i, int difference, float lineSpacing, int gap, int y, String withoutNor, int width, int oneTenHeight, int oneTenWidth, String[] substrings) {


        if (withoutNor.length() != 1) {

            canvas.drawLine(width / 2f, y, width / 2f, y + oneTenHeight, mPaint);
            canvas.drawLine(width / 2f, y, width / 2f + oneTenWidth, y, mPaint);
            canvas.drawLine(width / 2f + oneTenWidth, y, width / 2f + oneTenWidth, y + oneTenHeight, mPaint);
            canvas.drawLine(width / 2f, y + oneTenHeight, width / 2f + oneTenWidth, y + oneTenHeight, mPaint);
        }

        float verticalLineX = width / 2f + oneTenWidth * 2 - difference * i;
        int i1 = oneTenHeight + substrings.length * oneTenHeight + (substrings.length - 1) * gap;
        float v1 = i1 / 2f + oneTenHeight / 2f;
        float v2 = i1 / 2 + oneTenHeight / 2 - lineSpacing * (substrings.length / 2 - i);
        int i3 = width / 2 + oneTenWidth * 2 - difference * i;
        if (substrings.length % 2 == 0) {
            float x = width / 2f + oneTenWidth * 2 - difference * (substrings.length / 2f - 1) - difference * (substrings.length / 2 - i);
            if (substrings.length == 2) {
                float v = v1 - lineSpacing * (substrings.length / 2f - i);
                if (i < substrings.length / 2) {
                    canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, verticalLineX, y + oneTenHeight / 2f, mPaint);
                    float stopY = v + oneTenHeight / 2f;
                    canvas.drawLine(verticalLineX, y + oneTenHeight / 2f, verticalLineX, stopY, mPaint);
                    canvas.drawLine(verticalLineX, stopY, width / 2f + width / 4f, stopY, mPaint);
                } else {
                    float v3 = difference * (substrings.length / 2f - i);
                    canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, width / 2f + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - v3, y + oneTenHeight / 2f, mPaint);
                    canvas.drawLine(x, y + oneTenHeight / 2f, width / 2f + oneTenWidth * 2 - difference * (substrings.length / 2f - 1) - v3, v + oneTenHeight / 5f, mPaint);
                    canvas.drawLine(x, v + oneTenHeight / 5f, width / 2f + width / 4f, v + oneTenHeight / 5f, mPaint);
                }
            } else {
                float y1 = v2 + oneTenHeight / 16f;
                float v = i1 / 2 + oneTenHeight / 2f - lineSpacing * (substrings.length / 2 - i);
                int i2 = width / 2 + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i);
                float v3 = width / 2f + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i);
                if (substrings.length == 4) {

                    if (i < substrings.length / 2) {
                        canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, verticalLineX, y + oneTenHeight / 2f, mPaint);
                        canvas.drawLine(verticalLineX, y + oneTenHeight / 2f, i3, v + oneTenHeight / 5f, mPaint);
                        canvas.drawLine(verticalLineX, v2 + oneTenHeight / 5f, width / 2f + width / 4f, v2 + oneTenHeight / 5f, mPaint);
                    } else {
                        canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, v3, y + oneTenHeight / 2f, mPaint);
                        canvas.drawLine(x, y + oneTenHeight / 2f, i2, y1, mPaint);
                        canvas.drawLine(x, v2 + oneTenHeight / 16f, width / 2f + width / 4f, y1, mPaint);
                    }
                } else {
                    float y2 = v + oneTenHeight / 16f;
                    if (i < substrings.length / 2) {
                        canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, i3, y + oneTenHeight / 2f, mPaint);
                        canvas.drawLine(verticalLineX, y + oneTenHeight / 2f, i3, v2 + oneTenHeight / 16f, mPaint);
                        canvas.drawLine(verticalLineX, y1, width / 2f + width / 4f, y2, mPaint);
                    } else {
                        canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, v3, y + oneTenHeight / 2f, mPaint);
                        canvas.drawLine(x, y + oneTenHeight / 2f, i2, v2 + oneTenHeight / 16f, mPaint);
                        canvas.drawLine(x, y1, width / 2f + width / 4f, y2, mPaint);
                    }
                }
            }
        } else {
            if (i == substrings.length / 2) {
                canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, width / 2f + width / 4f, y + oneTenHeight / 2f, mPaint);
            } else if (i < substrings.length / 2) {
                canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, i3, y + oneTenHeight / 2f, mPaint);
                canvas.drawLine(verticalLineX, y + oneTenHeight / 2f, i3, v2, mPaint);
                canvas.drawLine(verticalLineX, v2, width / 2f + width / 4f, v2, mPaint);
            } else {
                canvas.drawLine(width / 2f + oneTenWidth, y + oneTenHeight / 2f, width / 2 + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i + 1), y + oneTenHeight / 2, mPaint);
                float v = width / 2f + oneTenWidth * 2 - difference * (substrings.length / 2 - 1) - difference * (substrings.length / 2 - i + 1);
                canvas.drawLine(v, y + oneTenHeight / 2f, v, v2, mPaint);
                canvas.drawLine(v, v1 - lineSpacing * (substrings.length / 2 - i), width / 2f + width / 4f, v2, mPaint);
            }
        }
    }

    private void drawEndRect(Canvas canvas, int width, int oneTenHeight, int oneTenWidth, int gap, String[] substrings, Paint mPaint) {
        Log.v("AAAA", String.valueOf(substrings.length));
        int y = (oneTenHeight + substrings.length * oneTenHeight + (substrings.length - 1) * gap) / 2;
        int xStart = width / 2 + width / 4;
        canvas.drawLine(xStart, y, xStart, y + oneTenHeight, mPaint);
        canvas.drawLine(xStart, y, xStart + oneTenWidth, y, mPaint);
        canvas.drawLine(xStart + oneTenWidth, y, xStart + oneTenWidth, y + oneTenHeight, mPaint);
        canvas.drawLine(xStart, y + oneTenHeight, xStart + oneTenWidth, y + oneTenHeight, mPaint);
        canvas.drawLine(xStart + oneTenWidth, y + oneTenHeight / 2f, width, y + oneTenHeight / 2f, mPaint);
    }
}

