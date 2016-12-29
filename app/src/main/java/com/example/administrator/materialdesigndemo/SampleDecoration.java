package com.example.administrator.materialdesigndemo;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.materialdesigndemo.RecyclerViewAdapter;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class SampleDecoration extends RecyclerView.ItemDecoration {
    private RecyclerViewAdapter adapter;

    public SampleDecoration(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
//        if (position!=parent.getChildCount()-1){
        outRect.left = outRect.left + 20;
        outRect.top = outRect.top + 20;
        outRect.right = outRect.right + 20;
        outRect.bottom = outRect.bottom + 20;
//        }
    }
}
