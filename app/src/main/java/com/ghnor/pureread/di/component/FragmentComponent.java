package com.ghnor.pureread.di.component;

import android.app.Activity;
import android.content.Context;

import com.ghnor.pureread.di.module.FragmentModule;
import com.ghnor.pureread.di.scope.ContextLife;
import com.ghnor.pureread.di.scope.FragmentScope;
import com.ghnor.pureread.view.gank.GankTechFragment;

import dagger.Component;

/**
 * Created by ghnor on 2016/11/7.
 */

@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(GankTechFragment gankTechFragment);
}
