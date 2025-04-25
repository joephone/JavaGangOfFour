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
import com.transcendence.gangoffour.main.BaseActivity;
import com.transcendence.gangoffour.main.TitleBarActivity;
import com.transcendence.gangoffour.utils.StringUtils;

import java.util.List;

/**
 * @author Joephone on 2024/12/1 0:45
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 结构型模式
 * @Edition 1.0
 * @EditionHistory
 */

public class StructuralMainActivity extends TitleBarActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String> adapter;
    private ListView lvIndex;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        setTitle("结构型模式");
        lvIndex = findViewById(R.id.lvIndex);

        List<String> items = StringUtils.getStringListAndIndex(this,R.array.index_patterns_structural_02);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);

        lvIndex.setAdapter(adapter);
        lvIndex.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, AppConstantValue.mainPatternsStructural[position]);
        startActivity(intent);
    }
}