package com.ghnor.pureread;

import android.app.Application;

import com.ghnor.pureread.di.component.ApplicationComponent;
import com.ghnor.pureread.di.component.DaggerApplicationComponent;
import com.ghnor.pureread.di.module.ApplicationModule;
import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by ghnor on 2016/11/7.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
        QbSdk.initX5Environment(this, null);
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
