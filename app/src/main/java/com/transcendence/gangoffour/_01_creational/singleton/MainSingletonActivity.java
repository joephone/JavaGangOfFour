package com.transcendence.gangoffour._01_creational.singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.transcendence.gangoffour.R;
import com.transcendence.gangoffour.utils.StringUtils;

import java.util.List;

/**
 * @author Joephone on 2024/12/1 0:38
 * @E-Mail Address：joephonechen@gmail.com
 * @Desc 单例模式
 * @Edition 1.0
 * @EditionHistory
 */

public class MainSingletonActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private final String TAG = "wan";
    private ArrayAdapter<String> adapter;
    private ListView lvIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvIndex = findViewById(R.id.lvIndex);

        List<String> items = StringUtils.getStringListAndIndex(this,R.array.index_patterns_creational_singleton);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);

        lvIndex.setAdapter(adapter);
        lvIndex.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent();
//        intent.setClass(this, AppConstantValue.mainPatternsCreationalSingleton[position]);
//        startActivity(intent);
        switch (position){
            case 0:
                SingletonEager.getInstance().doSomething();
                break;
            case 1:
                SingletonLazy.getInstance().doSomething();
                break;
            case 2:
                SingletonLazyThreadSafe.getInstance().doSomething();
                break;
            case 3:
                SingletonLazyStaticInnerClass.getInstance().doSomething();
                break;
        }
    }
}