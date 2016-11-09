package com.ghnor.pureread.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.ghnor.pureread.di.scope.ContextLife;
import com.ghnor.pureread.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghno2016/11/7.
 */

@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mFragment.getActivity();
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @FragmentScope
    public Fragment provideFragment() {
        return mFragment;
    }
}
