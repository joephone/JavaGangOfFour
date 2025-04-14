package com.transcendence.gangoffour._01_creational.factory.factorymethod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CircleView extends View implements ShapeView {
    private final Paint paint;

    public CircleView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true); // 开启抗锯齿
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        float radius = Math.min(getWidth(), getHeight()) / 2f;
//        canvas.drawCircle(getWidth()/2f, getHeight()/2f, radius, paint);

        // 在View中心绘制圆形
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;
        float radius = Math.min(getWidth(), getHeight()) / 3f; // 取1/3尺寸作为半径
        canvas.drawCircle(centerX, centerY, radius, paint);
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
