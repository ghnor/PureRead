package com.ghnor.pureread.di.module;

import android.app.Service;
import android.content.Context;

import com.ghnor.pureread.di.scope.ContextLife;
import com.ghnor.pureread.di.scope.ServiceScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghnor on 2016/11/7.
 */

@Module
public class ServiceModule {
    private Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

    @Provides
    @ServiceScope
    @ContextLife("Service")
    public Context ProvideServiceContext() {
        return mService;
    }
}
