package com.transcendence.gangoffour._02_structural.bridge;

import android.content.Context;
import android.graphics.Canvas;

/**
 * @author joephone
 * @date 2025/4/14 23:24
 * @description
 * @edition 1.0
 */
public class SquareView extends ShapeView {

    public SquareView(Context context, ColorInterFace color) {
        super(context, color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float size = Math.min(getWidth(), getHeight()) / 2f;
        float left = getWidth()/2f - size/2;
        float top = getHeight()/2f - size/2;
        canvas.drawRect(left, top, left + size, top + size, paint);
    }

}