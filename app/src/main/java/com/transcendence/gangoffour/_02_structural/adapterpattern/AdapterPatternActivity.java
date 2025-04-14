package com.transcendence.gangoffour._02_structural.adapterpattern;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;

/**
 * @author joephone
 * @date 2025/4/14 22:47
 * @description
 * @edition 1.0
 */
public class AdapterPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_adapter);

        FrameLayout container = findViewById(R.id.fl_container);

        // 创建Legacy矩形视图
        LegacyRectangleView legacyView = new LegacyRectangleView(this);

        // 创建适配器  面向接口编程，符合「依赖倒置原则」
        Shape adapter = new RectangleAdapter(legacyView);

        // 设置视图尺寸并添加到容器
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        container.addView(legacyView, params);

        // 通过适配器绘制矩形（居中显示）
        container.post(() -> {
            int width = container.getWidth() / 2;
            int height = container.getHeight() / 3;
            int startX = (container.getWidth() - width) / 2;
            int startY = (container.getHeight() - height) / 2;

            adapter.draw(startX, startY, width, height);
        });
    }
}