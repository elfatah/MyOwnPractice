package com.example.elfatahwashere.presenter;

import com.example.elfatahwashere.model.Movie;

import java.util.List;

/**
 * Created by elfatahwashere on 9/20/2016.
 */

public interface MoviesMvpView extends MvpView {
    void showMovies(List<Movie> movies);

    interface MovieDetails extends MvpView{
        void showMovieDetails(Movie movie);
    }
}
