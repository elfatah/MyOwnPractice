package com.example.elfatahwashere.di.component;



import com.example.elfatahwashere.di.ActivityScope;
import com.example.elfatahwashere.view.activity.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends ApplicationComponent {

    void inject(MainActivity mainActivity);
}