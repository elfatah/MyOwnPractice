package com.example.elfatahwashere.di.component;

import com.example.elfatahwashere.BaseApplication;
import com.example.elfatahwashere.api.APIService;
import com.example.elfatahwashere.api.UnauthorisedInterceptor;
import com.example.elfatahwashere.di.module.ApplicationModule;
import com.example.elfatahwashere.presenter.impl.MovieDetailsPresenter;
import com.example.elfatahwashere.presenter.impl.MoviesPresenter;
//import com.example.elfatahwashere.presenter.NewsPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    //void inject(MainPresenter mainPresenter);

    void inject(MovieDetailsPresenter movieDetailsPresenter);

    void inject(MoviesPresenter moviesPresenter);

    void inject(BaseApplication baseApplication);

    void inject(UnauthorisedInterceptor unauthorisedInterceptor);

    APIService apiService();

    EventBus eventBus();

    Realm realm();

    //PreferencesHelper prefsHelper();

}