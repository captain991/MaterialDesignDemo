package com.example.administrator.materialdesigndemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.materialdesigndemo.Bean.RecyclerViewItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<RecyclerViewItem> items;
    private Context mContext;

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final RecyclerViewItem recyclerViewItem = items.get(position);
        Glide.with(mContext).load(recyclerViewItem.getResId()).into(holder.imageView);
        holder.textView.setText(recyclerViewItem.getItemName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("imgResId", recyclerViewItem.getResId());
                intent.putExtra("title", recyclerViewItem.getItemName());
                Log.d("captain", position + "");
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, null);
        return new ViewHolder(view);
    }

    public RecyclerViewAdapter(List<RecyclerViewItem> items, Activity context) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView imageView;
        @BindView(R.id.item_tv)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
