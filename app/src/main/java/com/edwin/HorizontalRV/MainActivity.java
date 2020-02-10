package com.edwin.HorizontalRV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView ;
    ItemAdapter itemAdapter;
    ArrayList<DataModel> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        initData();
        initViews();

    }

    void initData(){

        String[] title = getResources().getStringArray(R.array.data_title);
        String[] detail = getResources().getStringArray(R.array.data_detail);
        TypedArray image = getResources().obtainTypedArray(R.array.data_poster);
        String[] color = getResources().getStringArray(R.array.data_color);
        for (int i = 0; i < title.length; i++) {
            listItems.add(new DataModel(title[i], detail[i], image.getResourceId(i, 0), color[i]));
        }
        image.recycle();

        itemAdapter = new ItemAdapter(getApplicationContext(),listItems);
        mRecyclerView.setAdapter(itemAdapter);
    }


    private void initViews(){
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);
    }

}
