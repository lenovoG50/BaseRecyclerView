package com.example.lenovo.baserecyclerview.wrapper;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.lenovo.baserecyclerview.MultiItemTypeAdapter;
import com.example.lenovo.baserecyclerview.base.ItemViewDelegate;
import com.example.lenovo.baserecyclerview.base.ViewHolder;

import java.util.List;

/**
 * Time:16:54
 * Author:lenovo
 * Description:新生成的类
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, final int layoutId, List<T> datas)
    {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);

}