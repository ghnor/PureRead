package com.ghnor.pureread.di.module;

import android.app.Activity;
import android.content.Context;

import com.ghnor.pureread.di.scope.ActivityScope;
import com.ghnor.pureread.di.scope.ContextLife;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghnor on 2016/11/7.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    @ContextLife("Activity")
    public Context ProvideActivityContext() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    public Activity ProvideActivity() {
        return mActivity;
    }
}
