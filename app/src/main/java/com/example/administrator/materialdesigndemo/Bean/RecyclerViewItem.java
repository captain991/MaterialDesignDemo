package com.example.administrator.materialdesigndemo.Bean;

/**
 * Created by Administrator on 2016/12/5 0005.
 */
public class RecyclerViewItem {
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public RecyclerViewItem(int resId, String itemName) {
        this.resId = resId;
        this.itemName = itemName;
    }

    private int resId;
    private String itemName;
}
