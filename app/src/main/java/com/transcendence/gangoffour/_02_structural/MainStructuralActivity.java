package com.transcendence.gangoffour._02_structural;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.main.AppConstantValue;
import com.transcendence.gangoffour.R;
import com.transcendence.gangoffour.utils.StringUtils;

import java.util.List;

/**
 * @author Joephone on 2024/12/1 0:45
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 结构型模式
 * @Edition 1.0
 * @EditionHistory
 */

public class MainStructuralActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private final String TAG = "wan";
    private ArrayAdapter<String> adapter;
    private ListView lvIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvIndex = findViewById(R.id.lvIndex);

        List<String> items = StringUtils.getStringListAndIndex(this,R.array.index_patterns_structural_02);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);

        lvIndex.setAdapter(adapter);
        lvIndex.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, AppConstantValue.mainPatterns[position]);
        startActivity(intent);
    }
}