package com.ghnor.pureread.di.component;

import android.content.Context;

import com.ghnor.pureread.di.module.ApplicationModule;
import com.ghnor.pureread.di.scope.ApplicationScope;
import com.ghnor.pureread.di.scope.ContextLife;

import dagger.Component;

/**
 * Created by ghnor on 2016/11/7.
 */

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}
