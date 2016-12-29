package com.example.administrator.materialdesigndemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.example.administrator.materialdesigndemo.Bean.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    private List<RecyclerViewItem> itemList = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerViewItem[] itemArray;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            resetList();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        init();
    }

    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        itemArray = new RecyclerViewItem[]{
                new RecyclerViewItem(R.drawable.a, "I won't mistake \nyou for problems with me."),
                new RecyclerViewItem(R.drawable.b, "I won't let\nmy moods ruin this you'll see.\nI won't take everything\ngood and move it away."),
                new RecyclerViewItem(R.drawable.c, "I won't be left dancing along\nto the songs from the past."),
                new RecyclerViewItem(R.drawable.d, "Would you stay home and keep\nour memories warm with me?"),
                new RecyclerViewItem(R.drawable.e, "Would you give all your love\nfor a run at the past with me"),
                new RecyclerViewItem(R.drawable.f, "I know you're sad even though you said you're not.\nI know you're scared even though you said you're not."),
                new RecyclerViewItem(R.drawable.g, "I won't get mad\nwhen you say thing are getting too hard."),
                new RecyclerViewItem(R.drawable.h, "I won't make all of your love\nso scared to come through our yard."),
                new RecyclerViewItem(R.drawable.i, "I won't scream in my head\nand let it isolate me."),
                new RecyclerViewItem(R.drawable.j, "I won't be left...")};

        adapter = new RecyclerViewAdapter(itemList, this);
        resetList();
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        SampleDecoration decoration = new SampleDecoration(adapter);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.currentThread().sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });

    }

    public void resetList() {
        itemList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int position = random.nextInt(10);
            itemList.add(itemArray[position]);
        }
        swipeRefresh.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

}
