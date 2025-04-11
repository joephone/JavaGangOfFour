package com.transcendence.gangoffour._01_creational.singleton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvIndex = findViewById(R.id.lvIndex);
        tvResult = findViewById(R.id.tvResult);

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
            case 0:  // 饿汉式
                SingletonEager.getInstance().doSomething();
                SingletonEager instance1 = SingletonEager.getInstance();
                SingletonEager instance2 = SingletonEager.getInstance();
                tvResult.setText(
                        "饿汉式:\n" +
                                "Instance 1: " + instance1.hashCode() + "\n" +
                                "Instance 2: " + instance2.hashCode()
                );
                break;
            case 1:  // 懒汉式（非线程安全）
                SingletonLazy instance3 = SingletonLazy.getInstance();
                SingletonLazy instance4 = SingletonLazy.getInstance();
                tvResult.setText(
                        "懒汉式（非线程安全）:\n" +
                                "Instance 3: " + instance3.hashCode() + "\n" +
                                "Instance 4: " + instance4.hashCode()
                );
                break;
            case 2: // 懒汉式（线程安全）
                tvResult.setText("懒汉式（线程安全）  Starting 5 threads to get instance...");
                for (int i = 0; i < 5; i++) {
                    new Thread(() -> {
                        SingletonLazyThreadSafe instance = SingletonLazyThreadSafe.getInstance();
                        runOnUiThread(() ->
                                tvResult.append("\nThread " + Thread.currentThread().getId() +
                                        ": " + instance.hashCode())
                        );
                    }).start();
                }
                break;
            case 3: // 静态内部类
                SingletonLazyStaticInnerClass.getInstance().doSomething();
                tvResult.setText(
                        "静态内部类:\n" +
                                "Instance: " + SingletonLazyStaticInnerClass.getInstance().hashCode()
                );
                break;
        }
    }
}