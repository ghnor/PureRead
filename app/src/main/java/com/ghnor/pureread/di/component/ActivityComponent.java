package com.ghnor.pureread.di.component;

import android.app.Activity;
import android.content.Context;

import com.ghnor.pureread.di.module.ActivityModule;
import com.ghnor.pureread.di.scope.ActivityScope;
import com.ghnor.pureread.di.scope.ContextLife;

import dagger.Component;

/**
 * Created by ghnor on 2016/11/7.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();
}
