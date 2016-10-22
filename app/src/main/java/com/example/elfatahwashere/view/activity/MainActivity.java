package com.example.elfatahwashere.view.activity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;

import com.example.elfatahwashere.adapter.MoviesRecycleAdapter;
import com.example.elfatahwashere.base.ui.BaseActivity;
import com.example.elfatahwashere.base.ui.view.BaseRecyclerView;
import com.example.elfatahwashere.model.Movie;
import com.example.elfatahwashere.model.MovieRealm;
import com.example.elfatahwashere.myownpractice.R;
import com.example.elfatahwashere.presenter.MoviesMvpView;
import com.example.elfatahwashere.presenter.impl.MoviesPresenter;
import com.example.elfatahwashere.storage.RealmConfig;
import com.example.elfatahwashere.view.MovieItemView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements MoviesMvpView, MovieItemView.OnActionListener {

    @Bind(R.id.rvMovies)
    BaseRecyclerView rvMovies;

    private MoviesPresenter moviesPresenter;
    private MoviesRecycleAdapter moviesRecycleAdapter;
    private int current_page;


    @Override
    protected int getResourceLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        current_page = 1;
        setUpAdapter();
        setUpRecyclerView();
        setUpPresenter();
    }

    private void setUpPresenter() {
        moviesPresenter = new MoviesPresenter(this);
        moviesPresenter.attachView(this);
        moviesPresenter.loadMovies(current_page);
    }

    private void setUpRecyclerView() {
        rvMovies.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(llm);
        rvMovies.setAdapter(moviesRecycleAdapter);

        rvMovies.setPullRefreshEnabled(true);
        rvMovies.setLoadingMoreEnabled(true);
        rvMovies.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                current_page = 1;
                moviesPresenter.loadMovies(current_page);
            }

            @Override
            public void onLoadMore() {
                current_page++;
                moviesPresenter.loadMovies(current_page);
            }
        });
    }

    private void setUpAdapter() {
        moviesRecycleAdapter = new MoviesRecycleAdapter(this);
        moviesRecycleAdapter.setOnActionListener(this);
    }

    @Override
    public void showMovies(List<Movie> movies) {

//        List<Reminder> domainList = converter.toDomainList(storageList);
        if (current_page == 1) {
            moviesRecycleAdapter.getDatas().clear();
        }

//        movies.addAll(storageList);
        moviesRecycleAdapter.addAll(movies);
        rvMovies.refreshComplete();
        rvMovies.loadMoreComplete();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    public void onClick(MovieItemView view) {
        showToast(view.getMovie().getOriginalTitle());
        Intent detailsIntent = new Intent(this, MovieDetailActivity.class);
        detailsIntent.putExtra("ID_MOVIES", view.getMovie().getId());
        startActivity(detailsIntent);


    }
}
