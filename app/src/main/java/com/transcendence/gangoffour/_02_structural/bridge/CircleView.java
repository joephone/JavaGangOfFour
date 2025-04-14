package com.transcendence.gangoffour._02_structural.bridge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

/**
 * @author joephone
 * @date 2025/4/14 23:10
 * @description
 * @edition 1.0
 */
public class CircleView extends ShapeView {
    public CircleView(Context context, ColorInterFace color) {
        super(context, color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float radius = Math.min(getWidth(), getHeight()) / 3f;
        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, radius, paint);

    }
}