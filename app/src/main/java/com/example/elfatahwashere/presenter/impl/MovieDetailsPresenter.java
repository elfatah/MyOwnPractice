package com.example.elfatahwashere.presenter.impl;

import android.content.Context;

import com.example.elfatahwashere.BaseApplication;
import com.example.elfatahwashere.api.APIService;
import com.example.elfatahwashere.base.presenter.BasePresenter;
import com.example.elfatahwashere.model.Movie;
import com.example.elfatahwashere.model.MoviesResponse;
import com.example.elfatahwashere.myownpractice.R;
import com.example.elfatahwashere.presenter.MoviesMvpView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by elfatahwashere on 9/21/2016.
 */

public class MovieDetailsPresenter implements BasePresenter<MoviesMvpView.MovieDetails> {
    private Subscription subscription;
    private Movie movieDetails;
    private MoviesMvpView.MovieDetails MpvMovieDetails;

    @Inject
    public MovieDetailsPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;

    @Override
    public void attachView(MoviesMvpView.MovieDetails view) {
        MpvMovieDetails = view;
    }

    @Override
    public void detachView() {
        MpvMovieDetails = null;
        if (subscription != null) subscription.unsubscribe();

    }

    public void loadMovies(int page) {
        if (subscription != null) subscription.unsubscribe();
        BaseApplication baseApplication = BaseApplication.get(MpvMovieDetails.getContext());

        subscription = mAPIService.getTopRatedMovies(baseApplication.getString(R.string.api_key), page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<MoviesResponse>() {
                    @Override
                    public void onCompleted() {
                        MpvMovieDetails.showMovieDetails(movieDetails);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MoviesResponse moviesResponse) {
                        movieDetails = moviesResponse.getResults().get(0);
                    }
                });
    }
}
