package com.transcendence.gangoffour._01_creational;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.log.LogUtils;
import com.transcendence.gangoffour.main.AppConstantValue;
import com.transcendence.gangoffour.R;
import com.transcendence.gangoffour.main.BaseActivity;
import com.transcendence.gangoffour.main.TitleBarActivity;
import com.transcendence.gangoffour.utils.StringUtils;

import java.util.List;

/**
 * @author Joephone on 2024/12/1 0:38
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 创建型模式
 * @Edition 1.0
 * @EditionHistory
 */

public class CreationalMainActivity extends TitleBarActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<String> adapter;
    private ListView lvIndex;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        setTitle("创建型模式");
        // 调试状态栏高度
        LogUtils.d("TitleBarDebug", "StatusBar height: " + getStatusBarHeight());
        lvIndex = findViewById(R.id.lvIndex);

        List<String> items = StringUtils.getStringListAndIndex(this,R.array.index_patterns_creational_01);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);

        lvIndex.setAdapter(adapter);
        lvIndex.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, AppConstantValue.mainPatternsCreational[position]);
        startActivity(intent);
    }
}