package com.example.elfatahwashere.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.elfatahwashere.base.ui.adapter.BaseRecyclerAdapter;
import com.example.elfatahwashere.base.ui.adapter.viewholder.BaseItemViewHolder;
import com.example.elfatahwashere.model.Movie;
import com.example.elfatahwashere.myownpractice.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by elfatahwashere on 9/20/2016.
 */

public class MovieItemView extends BaseItemViewHolder<Movie> {
    protected OnActionListener mActionListener;
    public final static String imgBasePath = "http://image.tmdb.org/t/p/w500/";
    @Bind(R.id.subtitle)
    TextView tvSubtitle;

//    @Bind(R.id.cvMovies)
//    CardView cvMovies;

//    @Bind(R.id.movies_layout)
//    LinearLayout llMoviesl;

    @Bind(R.id.title)
    TextView tvTitle;

    @Bind(R.id.rating)
    TextView tvRating;

    @Bind(R.id.description)
    TextView tvDesc;

    @Bind(R.id.ivPoster)
    ImageView ivPoster;

    private Movie movie;

    public MovieItemView(Context context, View itemView, BaseRecyclerAdapter.OnItemClickListener itemClickListener, BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = context;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public void setOnActionListener(OnActionListener listener) {
        mActionListener = listener;
    }


    @OnClick(R.id.movies_layout)
    void itemClicked(){
        if (mActionListener != null) {
            mActionListener.onClick(MovieItemView.this);
        }
    }

    @Override
    public void bind(Movie movie) {
        setMovie(movie);
        tvSubtitle.setText(movie.getReleaseDate());
        tvDesc.setText(movie.getOverview());
        tvTitle.setText(movie.getTitle());
        tvRating.setText("Rating: "+movie.getVoteAverage());
        Glide.with(mContext)
                .load(imgBasePath + movie.getPosterPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .placeholder(R.drawable.loading_02)
                .into(ivPoster);

    }

    public interface OnActionListener {

        void onClick(MovieItemView view);
    }
}
