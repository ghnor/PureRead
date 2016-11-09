package com.ghnor.pureread.di.component;

import android.content.Context;

import com.ghnor.pureread.di.module.ServiceModule;
import com.ghnor.pureread.di.scope.ContextLife;
import com.ghnor.pureread.di.scope.ServiceScope;

import dagger.Component;

/**
 * Created by ghnor on 2016/11/7.
 */

@ServiceScope
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    @ContextLife("Service")
    Context getServiceContext();

    @ContextLife("Application")
    Context getApplicationContext();
}
