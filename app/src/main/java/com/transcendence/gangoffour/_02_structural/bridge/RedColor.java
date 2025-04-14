package com.transcendence.gangoffour._02_structural.bridge;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author joephone
 * @date 2025/4/14 23:08
 * @description
 * @edition 1.0
 */
public class RedColor implements ColorInterFace {
    @Override
    public int getColorValue() {
        return Color.RED;
    }

    @Override
    public void applyPaint(Paint paint) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
    }
}