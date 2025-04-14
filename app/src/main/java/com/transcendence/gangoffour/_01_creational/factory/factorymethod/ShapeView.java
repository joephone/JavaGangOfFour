package com.transcendence.gangoffour._01_creational.factory.factorymethod;

import android.graphics.Canvas;
import android.view.View;

/**
 * @author asus
 */
public interface ShapeView {
    void draw(Canvas canvas);
    void layout(int left, int top, int right, int bottom);
    View getView();
}
