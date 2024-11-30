package com.transcendence.gangoffour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private final String TAG = "wan";

    private ArrayAdapter<String> adapter;
    private ListView lvIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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