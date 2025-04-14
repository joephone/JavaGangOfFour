package com.transcendence.gangoffour._02_structural.adapterpattern;

import android.view.View;

/**
 * @author joephone
 * @date 2025/4/14 22:46
 * @description
 * @edition 1.0
 */
public class RectangleAdapter implements Shape {
    private final LegacyRectangleView legacyView;

    public RectangleAdapter(LegacyRectangleView legacyView) {
        this.legacyView = legacyView;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        int x2 = x + width;
        int y2 = y + height;
        legacyView.display(x, y, x2, y2);
    }

    @Override
    public View getView() {
        return legacyView;
    }
}