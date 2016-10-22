package com.example.elfatahwashere;

import android.app.Application;
import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.example.elfatahwashere.di.component.ApplicationComponent;
import com.example.elfatahwashere.di.component.DaggerApplicationComponent;
import com.example.elfatahwashere.di.module.ApplicationModule;
import com.example.elfatahwashere.events.AuthenticationErrorEvent;
import com.example.elfatahwashere.storage.RealmConfig;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class BaseApplication extends Application {

    private Scheduler mScheduler;
    private ApplicationComponent mApplicationComponent;
    @Inject
    EventBus mEventBus;


    @Override
    public void onCreate() {
        super.onCreate();



        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
        mEventBus.register(this);
        RealmConfiguration realmConfiguration = RealmConfig.getRealmConfiguration(this);

        Realm.setDefaultConfiguration(realmConfiguration);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @VisibleForTesting
    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.mApplicationComponent = applicationComponent;
    }

    public Scheduler getSubscribeScheduler() {
        if (mScheduler == null) {
            mScheduler = Schedulers.io();
        }
        return mScheduler;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        mEventBus.unregister(this);
        super.onTerminate();
    }

    @Subscribe
    public void onEvent(AuthenticationErrorEvent event) {
        Log.e("TAG", "Unauthorized! Redirect to Signin Activity..!.");
    }

}
