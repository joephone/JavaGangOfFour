package com.transcendence.gangoffour._01_creational.prototype;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;

public class PrototypeActivity extends AppCompatActivity {

    private Shape originalShape;
    private Shape clonedShape;

    private TextView originalInfoText;
    private TextView clonedInfoText;
    private ImageView originalShapeView;
    private ImageView clonedShapeView;

    private Spinner shapeTypeSpinner;
    private SeekBar sizeSeekBar;
    private Button colorPickerButton;
    private Button cloneButton;
    private Button modifyCloneButton;

    private int selectedColor = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_prototype);

        // 初始化视图
        initViews();

        // 设置初始形状
        originalShape = new Shape("Circle", Color.RED, 100);
        updateShapeViews();

        // 设置监听器
        setupListeners();
    }

    private void initViews() {
        originalInfoText = findViewById(R.id.original_info);
        clonedInfoText = findViewById(R.id.cloned_info);
        originalShapeView = findViewById(R.id.original_shape);
        clonedShapeView = findViewById(R.id.cloned_shape);

        shapeTypeSpinner = findViewById(R.id.shape_type_spinner);
        sizeSeekBar = findViewById(R.id.size_seekbar);
        colorPickerButton = findViewById(R.id.color_picker);
        cloneButton = findViewById(R.id.clone_button);
        modifyCloneButton = findViewById(R.id.modify_clone_button);

        // 设置形状类型下拉菜单
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.shape_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shapeTypeSpinner.setAdapter(adapter);
    }

    private void setupListeners() {
        // 形状类型选择
        shapeTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                originalShape.setType(parent.getItemAtPosition(position).toString());
                updateShapeViews();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // 大小调整
        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                originalShape.setSize(progress + 50); // 最小50
                updateShapeViews();
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // 颜色选择
        colorPickerButton.setOnClickListener(v -> {
            ColorPickerDialog dialog = new ColorPickerDialog(this, selectedColor,
                    new ColorPickerDialog.OnColorSelectedListener() {
                        @Override
                        public void onColorSelected(int color) {
                            selectedColor = color;
                            originalShape.setColor(color);
                            colorPickerButton.setBackgroundColor(color);
                            updateShapeViews();
                        }
                    });
            dialog.show();
        });

        // 克隆按钮
        cloneButton.setOnClickListener(v -> {
            clonedShape = originalShape.clone();
            if (clonedShape != null) {
                clonedShape.setType("Cloned " + clonedShape.getType());
                updateShapeViews();
                Toast.makeText(this, "Shape cloned!", Toast.LENGTH_SHORT).show();
            }
        });

        // 修改克隆按钮
        modifyCloneButton.setOnClickListener(v -> {
            if (clonedShape != null) {
                clonedShape.setColor(Color.rgb(
                        (int)(Math.random() * 255),
                        (int)(Math.random() * 255),
                        (int)(Math.random() * 255)
                ));
                clonedShape.setSize((int)(Math.random() * 150 + 50));
                updateShapeViews();
                Toast.makeText(this, "Clone modified!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateShapeViews() {
        // 更新原始形状信息
        originalInfoText.setText(String.format(
                "Original Shape\nType: %s\nColor: #%06X\nSize: %dpx",
                originalShape.getType(),
                originalShape.getColor() & 0x00FFFFFF,
                originalShape.getSize()
        ));

        // 绘制原始形状
        originalShapeView.setImageDrawable(createShapeDrawable(originalShape));

        // 更新克隆形状信息
        if (clonedShape != null) {
            clonedInfoText.setText(String.format(
                    "Cloned Shape\nType: %s\nColor: #%06X\nSize: %dpx",
                    clonedShape.getType(),
                    clonedShape.getColor() & 0x00FFFFFF,
                    clonedShape.getSize()
            ));

            // 绘制克隆形状
            clonedShapeView.setImageDrawable(createShapeDrawable(clonedShape));
            clonedShapeView.setVisibility(View.VISIBLE);
            modifyCloneButton.setEnabled(true);
        } else {
            clonedInfoText.setText("No cloned shape");
            clonedShapeView.setVisibility(View.INVISIBLE);
            modifyCloneButton.setEnabled(false);
        }
    }

    private Drawable createShapeDrawable(Shape shape) {
        ShapeDrawable drawable = new ShapeDrawable();

        switch (shape.getType()) {
            case "Circle":
                drawable.setShape(new OvalShape());
                break;
            case "Square":
                drawable.setShape(new RectShape());
                break;
            case "Triangle":
                // 自定义三角形
                Path path = new Path();
                path.moveTo(0.5f, 0);
                path.lineTo(1, 1);
                path.lineTo(0, 1);
                path.close();
                drawable.setShape(new PathShape(path, 1, 1));
                break;
        }

        drawable.getPaint().setColor(shape.getColor());
        drawable.setIntrinsicWidth(shape.getSize());
        drawable.setIntrinsicHeight(shape.getSize());

        return drawable;
    }

}
