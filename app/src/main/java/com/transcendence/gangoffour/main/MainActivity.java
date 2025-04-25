package com.transcendence.gangoffour.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.transcendence.gangoffour.R;
import com.transcendence.gangoffour.main.AppConstantValue;
import com.transcendence.gangoffour.utils.StringUtils;

import java.util.List;

public class MainActivity extends TitleBarActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String> adapter;
    private ListView lvIndex;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        lvIndex = findViewById(R.id.lvIndex);

        List<String> items = StringUtils.getStringListAndIndex(this,R.array.index_patterns);
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