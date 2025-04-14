package com.transcendence.gangoffour._02_structural.adapterpattern;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * @author joephone
 * @date 2025/4/14 22:42
 * @description
 * @edition 1.0
 */
public class LegacyRectangleView extends View {
    private int x1, y1, x2, y2;
    private final Paint paint;

    public LegacyRectangleView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public void display(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        invalidate(); // 触发重绘
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制矩形
        canvas.drawRect(x1, y1, x2, y2, paint);

        // 绘制坐标文字
        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(24);
        canvas.drawText("P1("+x1+","+y1+")", x1, y1 - 10, textPaint);
        canvas.drawText("P2("+x2+","+y2+")", x2 - 100, y2 + 30, textPaint);
    }
}