package com.transcendence.gangoffour._01_creational.prototype;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.transcendence.gangoffour.R;

public class ColorPickerDialog extends Dialog {
    public interface OnColorSelectedListener {
        void onColorSelected(int color);
    }

    private final int initialColor;
    private final OnColorSelectedListener listener;

    public ColorPickerDialog(Context context, int initialColor, OnColorSelectedListener listener) {
        super(context);
        this.initialColor = initialColor;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_color_picker);

        // 初始化颜色选择视图
        ColorPickerView colorPickerView = findViewById(R.id.color_picker_view);
        colorPickerView.setInitialColor(initialColor);

        // 确认按钮
        Button btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(v -> {
            if (listener != null) {
                listener.onColorSelected(colorPickerView.getSelectedColor());
            }
            dismiss();
        });

        // 取消按钮
        Button btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(v -> dismiss());
    }
}
