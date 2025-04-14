package com.transcendence.gangoffour._02_structural.adapterpattern;

import android.view.View;

/**
 * @author joephone
 * @date 2025/4/14 22:43
 * @description
 * @edition 1.0
 */
public interface Shape {
    void draw(int x, int y, int width, int height);
    View getView();
}
