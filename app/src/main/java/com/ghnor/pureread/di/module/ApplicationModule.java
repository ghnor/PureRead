package com.ghnor.pureread.di.module;

import android.content.Context;

import com.ghnor.pureread.App;
import com.ghnor.pureread.di.scope.ApplicationScope;
import com.ghnor.pureread.di.scope.ContextLife;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghnor on 2016/11/7.
 */

@Module
public class ApplicationModule {
    private App mApplication;

    public ApplicationModule(App application) {
        mApplication = application;
    }

    @Provides
    @ApplicationScope
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
