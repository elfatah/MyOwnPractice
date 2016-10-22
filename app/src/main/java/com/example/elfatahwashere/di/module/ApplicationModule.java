package com.example.elfatahwashere.di.module;


import com.example.elfatahwashere.BaseApplication;
import com.example.elfatahwashere.api.APIService;
import com.example.elfatahwashere.storage.RealmConfig;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class ApplicationModule {

    private final BaseApplication mBaseApplication;

    public ApplicationModule(BaseApplication baseApplication) {
        this.mBaseApplication = baseApplication;
    }

    @Provides
    @Singleton
    public BaseApplication provideApplication() {
        return mBaseApplication;
    }

    @Provides
    @Singleton
    public APIService provideApiService() {
        return APIService.Factory.create(mBaseApplication);
    }

    @Provides
    @Singleton
    public EventBus eventBus() {
        return new EventBus();
    }

    @Provides
    @Singleton
    public Realm provideRealm() {

        return Realm.getInstance(RealmConfig.getRealmConfiguration(mBaseApplication.getApplicationContext()));

    }
    /*@Provides
    @Singleton
    public PreferencesHelper prefsHelper() {
        return new PreferencesHelper(mBaseApplication);
    }*/

}