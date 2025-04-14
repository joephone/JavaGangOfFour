package com.transcendence.gangoffour._01_creational.prototype;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

// ColorPickerView.java
public class ColorPickerView extends View {
    private Paint paint;
    private int selectedColor;
    private float selectorX, selectorY;

    public ColorPickerView(Context context) {
        super(context);
        init();
    }

    public ColorPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        selectedColor = Color.RED;
    }

    public void setInitialColor(int color) {
        selectedColor = color;
        invalidate();
    }

    public int getSelectedColor() {
        return selectedColor;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制颜色渐变
        int width = getWidth();
        int height = getHeight();
        float centerX = width / 2f;
        float centerY = height / 2f;
        float radius = Math.min(width, height) / 2f;

        // 绘制HSV颜色环
        float[] hsv = new float[]{0, 1, 1};
        for (int i = 0; i < 360; i++) {
            hsv[0] = i;
            paint.setColor(Color.HSVToColor(hsv));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawArc(0, 0, width, height, i, 1, true, paint);
        }

        // 绘制选择器
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawCircle(selectorX, selectorY, 20, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        // 计算触摸点对应的颜色
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;
        float radius = Math.min(getWidth(), getHeight()) / 2f;

        float distance = (float) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        if (distance <= radius) {
            selectorX = x;
            selectorY = y;

            float angle = (float) Math.toDegrees(Math.atan2(y - centerY, x - centerX));
            if (angle < 0) {
                angle += 360;
            }

            float[] hsv = new float[]{angle, 1, 1};
            selectedColor = Color.HSVToColor(hsv);
            invalidate();
        }

        return true;
    }
}
