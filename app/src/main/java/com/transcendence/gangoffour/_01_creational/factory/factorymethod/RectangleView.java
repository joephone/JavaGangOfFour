package com.transcendence.gangoffour._01_creational.factory.factorymethod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
public class RectangleView extends View implements ShapeView {
    private final Paint paint;

    public RectangleView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true); // 开启抗锯齿
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        // 在View中心绘制矩形
        float width = getWidth() / 2f;  // 矩形宽度为View宽度的一半
        float height = getHeight() / 2f; // 矩形高度为View高度的一半
        float left = getWidth() / 2f - width / 2;
        float top = getHeight() / 2f - height / 2;
        canvas.drawRect(left, top, left + width, top + height, paint);
    }

    @Override
    public void layout(int left, int top, int right, int bottom) {
        super.layout(left, top, right, bottom); // 调用View的原始布局方法
    }

    @Override
    public View getView() {
        return this;
    }
}
