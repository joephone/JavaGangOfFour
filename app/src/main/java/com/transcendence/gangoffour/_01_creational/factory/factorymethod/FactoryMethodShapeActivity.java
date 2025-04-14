package com.transcendence.gangoffour._01_creational.factory.factorymethod;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;

/**
 * @author asus
 */
public class FactoryMethodShapeActivity extends AppCompatActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_factory_method);

        FrameLayout container = findViewById(R.id.fl_container);

        // 等待布局完成
        container.post(() -> {
            int viewSize = Math.min(container.getWidth(), container.getHeight()) / 2;

            // 添加圆形View（上半部分）
            CircleView circleView = new CircleView(this);
            FrameLayout.LayoutParams circleParams = new FrameLayout.LayoutParams(
                    viewSize,
                    viewSize
            );
            circleParams.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
            container.addView(circleView, circleParams);

            // 添加矩形View（下半部分）
            RectangleView rectView = new RectangleView(this);
            FrameLayout.LayoutParams rectParams = new FrameLayout.LayoutParams(
                    viewSize,
                    viewSize
            );
            rectParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
            container.addView(rectView, rectParams);
        });
    }


}
