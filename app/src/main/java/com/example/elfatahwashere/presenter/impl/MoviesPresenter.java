package com.example.elfatahwashere.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.example.elfatahwashere.BaseApplication;
import com.example.elfatahwashere.api.APIService;
import com.example.elfatahwashere.base.presenter.BasePresenter;
import com.example.elfatahwashere.base.ui.BaseActivity;
import com.example.elfatahwashere.model.Movie;
import com.example.elfatahwashere.model.MovieRealm;
import com.example.elfatahwashere.model.MoviesResponse;
import com.example.elfatahwashere.myownpractice.R;
import com.example.elfatahwashere.presenter.MoviesMvpView;
import com.example.elfatahwashere.storage.RealmConfig;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by elfatahwashere on 9/20/2016.
 */

public class MoviesPresenter implements BasePresenter<MoviesMvpView> {
    private Subscription subscription;
    private List<Movie> movieList;
    private MoviesMvpView moviesMvpView;

    @Inject
    public MoviesPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    Realm realmDb;

    @Inject
    APIService mAPIService;


    @Override
    public void attachView(MoviesMvpView view) {
        moviesMvpView = view;
    }

    @Override
    public void detachView() {
        moviesMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadMovies(int page) {
        if (subscription != null) subscription.unsubscribe();
        BaseApplication baseApplication = BaseApplication.get(moviesMvpView.getContext());

        subscription = mAPIService.getTopRatedMovies(baseApplication.getString(R.string.api_key), page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<MoviesResponse>() {
                    @Override
                    public void onCompleted() {

                        moviesMvpView.showMovies(movieList);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MoviesResponse moviesResponse) {
                        movieList = moviesResponse.getResults();
                    }
                });
    }

    public boolean insert(final Movie model) {

        final MovieRealm movieRealm = new MovieRealm(
                model.getPosterPath(), model.isAdult(), model.getOverview(), model.getReleaseDate(),
                model.getId(), model.getOriginalTitle(), model.getOriginalLanguage(),
                model.getTitle(), model.getBackdropPath(), model.getPopularity(), model.getVoteCount(),
                model.getVideo(), model.getVoteAverage()
        );
//        Realm realm = Realm.getInstance(RealmConfig.getRealmConfiguration(moviesMvpView.getContext()));
        realmDb.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(movieRealm);

            }
        });
//        realm.close();
        Log.e("Inserted",movieRealm.getOriginalTitle());
        return true;
    }



}
