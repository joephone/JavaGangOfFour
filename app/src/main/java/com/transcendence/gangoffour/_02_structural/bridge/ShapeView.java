package com.transcendence.gangoffour._02_structural.bridge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * @author joephone
 * @date 2025/4/14 23:09
 * @description
 * @edition 1.0
 */
public abstract class ShapeView extends View {
    protected ColorInterFace color;
    protected Paint paint;

    public ShapeView(Context context, ColorInterFace color) {
        super(context);
        this.color = color;
        this.paint = new Paint();
        paint.setAntiAlias(true);
        color.applyPaint(paint);
    }

    @Override
    protected abstract void onDraw(Canvas canvas);
}