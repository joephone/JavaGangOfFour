package com.transcendence.gangoffour._01_creational.builder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;

/**
 *  builder模式
 */
public class BuilderActivity extends AppCompatActivity {

    private TextView houseDetailsText;
    private ImageView houseImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_builder);

        houseDetailsText = findViewById(R.id.house_details);
        houseImage = findViewById(R.id.house_image);

        Button buildStandardBtn = findViewById(R.id.build_standard_btn);
        Button buildLuxuryBtn = findViewById(R.id.build_luxury_btn);

        buildStandardBtn.setOnClickListener(v -> buildHouse(new ConcreteHouseBuilder(), R.drawable.standard_house));
        buildLuxuryBtn.setOnClickListener(v -> buildHouse(new LuxuryHouseBuilder(), R.drawable.luxury_house));
    }

    private void buildHouse(HouseBuilder builder, int imageResId) {
        Director director = new Director(builder);
        House house = director.constructHouse();

        houseDetailsText.setText(house.toString());
        houseImage.setImageResource(imageResId);

        Toast.makeText(this, "House built successfully!", Toast.LENGTH_SHORT).show();
    }

}
