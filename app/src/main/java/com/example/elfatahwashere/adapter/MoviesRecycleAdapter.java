package com.example.elfatahwashere.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.elfatahwashere.base.ui.adapter.BaseRecyclerAdapter;
import com.example.elfatahwashere.model.Movie;
import com.example.elfatahwashere.myownpractice.R;
import com.example.elfatahwashere.view.MovieItemView;

import java.util.List;

/**
 * Created by elfatahwashere on 9/20/2016.
 */

public class MoviesRecycleAdapter extends BaseRecyclerAdapter<Movie,MovieItemView> {
    private MovieItemView.OnActionListener mOnActionListener;

    public MoviesRecycleAdapter(Context context) {
        super(context);
    }


    public void setOnActionListener(MovieItemView.OnActionListener onActionListener) {
        mOnActionListener = onActionListener;
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.list_item_movie;
    }

    @Override
    public MovieItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieItemView contentView = new MovieItemView(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
        contentView.setOnActionListener(mOnActionListener);
        return contentView;
    }
}
