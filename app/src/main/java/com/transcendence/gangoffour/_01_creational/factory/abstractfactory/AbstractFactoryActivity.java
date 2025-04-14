package com.transcendence.gangoffour._01_creational.factory.abstractfactory;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;
import com.transcendence.gangoffour.log.LogUtils;

/**
 *  抽象工厂
 */
public class AbstractFactoryActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_factory_abstract);

        tvResult = findViewById(R.id.tv_result);
        Button windowsBtn = findViewById(R.id.btn_windows);
        Button linuxBtn = findViewById(R.id.btn_linux);

        windowsBtn.setOnClickListener(v -> runOS("windows"));
        linuxBtn.setOnClickListener(v -> runOS("linux"));
    }

    private void runOS(String osType) {
        OperatingSystem os = OSFactory.createOS(osType);
        os.run();

        String result = osType + " OS is running!";
        tvResult.setText(result);
        LogUtils.d("OSFactory", result);
    }
}
