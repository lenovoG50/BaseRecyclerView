package com.example.lenovo.baserecyclerview.wrapper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.baserecyclerview.base.ViewHolder;

/**
 * Time:15:14
 * Author:lenovo
 * Description:新生成的类
 */
public class EmptyWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_TYPE_EMPTY = Integer.MAX_VALUE - 1;
    private RecyclerView.Adapter mInnerAdapter;
    private View mEmptyView;
    private int mEmptyLayoutId;

    public EmptyWrapper(RecyclerView.Adapter mInnerAdapter) {
        this.mInnerAdapter = mInnerAdapter;
    }

    private boolean isEmpty() {
        return (mEmptyView != null || mEmptyLayoutId != 0) && mInnerAdapter.getItemCount() == 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (isEmpty()) {
            ViewHolder holder;
            if (mEmptyView != null) {
                holder = ViewHolder.createViewHolder(viewGroup.getContext(), viewGroup, mEmptyView);
            } else {
                holder = ViewHolder.createViewHolder(viewGroup.getContext(), viewGroup, mEmptyLayoutId);
            }
            return holder;
        }
        return mInnerAdapter.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (isEmpty()) {
            return;
        }
        mInnerAdapter.onBindViewHolder(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        if (isEmpty()) return 1;
        return mInnerAdapter.getItemCount();
    }

    //public void setItemTypeEmpty(View)

    public void setmEmptyView(View mEmptyView) {
        this.mEmptyView = mEmptyView;
    }
    public void setmEmptyView(int layoutId) {
        mEmptyLayoutId=layoutId;
    }
}
