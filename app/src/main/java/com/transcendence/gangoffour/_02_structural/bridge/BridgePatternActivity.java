package com.transcendence.gangoffour._02_structural.bridge;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;

/**
 * @author joephone
 * @date 2025/4/14 23:32
 * @description
 * @edition 1.0
 */
public class BridgePatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_bridge);

        FrameLayout container = findViewById(R.id.fl_container);

        // 创建颜色实现
        ColorInterFace redColor = new RedColor();
        ColorInterFace blueColor = new BlueColor();

        // 创建形状视图（桥接颜色和形状）
        ShapeView redCircle = new CircleView(this, redColor);
        ShapeView blueSquare = new SquareView(this, blueColor);

        // 设置布局参数
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                dpToPx(150), // 150dp
                dpToPx(150)  // 150dp
        );

        // 圆形位置
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        params.topMargin = dpToPx(50);
        container.addView(redCircle, params);

        // 方形位置
        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        params.bottomMargin = dpToPx(50);
        container.addView(blueSquare, params);
    }

    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}