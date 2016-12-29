package com.example.administrator.materialdesigndemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    private int imgResId;
    private String title;
    @BindView(R.id.img)
    ImageView imageView;
    @BindView(R.id.collapsingToolBar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.toolBar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        init();
    }

    public void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        imgResId = intent.getIntExtra("imgResId", R.drawable.a);
        title = intent.getStringExtra("title");
        Glide.with(this).load(imgResId).into(imageView);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#ffffff"));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ffffff"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
