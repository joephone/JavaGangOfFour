package com.transcendence.gangoffour._02_structural.bridge;

import android.graphics.Paint;

/**
 * @author joephone
 * @date 2025/4/14 23:08
 * @description
 * @edition 1.0
 */
public interface ColorInterFace {
    int getColorValue(); // 返回颜色值
    void applyPaint(Paint paint); // 应用颜色到画笔
}