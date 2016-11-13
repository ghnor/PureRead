package com.ghnor.pureread.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ghnor.pureread.App;
import com.ghnor.pureread.di.component.ActivityComponent;
import com.ghnor.pureread.di.component.DaggerActivityComponent;
import com.ghnor.pureread.di.module.ActivityModule;

/**
 * Created by ghnor on 2016/10/22.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    public abstract void initInject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initActivityComponent();
        initInject();
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    protected ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
