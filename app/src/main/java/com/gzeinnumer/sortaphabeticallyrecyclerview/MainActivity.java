package com.gzeinnumer.sortaphabeticallyrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private ExampleAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewAdapter = new ExampleAdapter(mExampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mRecyclerViewAdapter);

        Button buttonSortName = findViewById(R.id.button_sort_name);
        buttonSortName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mExampleList, new Comparator<ExampleItem>() {
                    @Override
                    public int compare(ExampleItem o1, ExampleItem o2) {
                        return o1.getText2().compareTo(o2.getText2());
                    }
                });

                mRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

        Button buttonSortNick = findViewById(R.id.button_sort_nick);
        buttonSortNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mExampleList, new Comparator<ExampleItem>() {
                    @Override
                    public int compare(ExampleItem o1, ExampleItem o2) {
                        return o1.getText1().compareTo(o2.getText1());
                    }
                });

                mRecyclerViewAdapter.notifyDataSetChanged();;
            }
        });
    }


    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.mipmap.ic_launcher, "Rick", "Grimes"));
        mExampleList.add(new ExampleItem(R.mipmap.ic_launcher, "Abraham", "Ford"));
        mExampleList.add(new ExampleItem(R.mipmap.ic_launcher, "Eugene", "Porter"));
        mExampleList.add(new ExampleItem(R.mipmap.ic_launcher, "Zein", "Fadli"));
        mExampleList.add(new ExampleItem(R.mipmap.ic_launcher, "Rendi", "Yulianto"));
        mExampleList.add(new ExampleItem(R.mipmap.ic_launcher, "Ririn", "Darmayanti"));
    }


}
