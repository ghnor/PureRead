package com.ghnor.pureread.base;

import android.support.annotation.NonNull;

/**
 * Created by ghnor on 2016/11/6.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(@NonNull T view) {

    }

    @Override
    public void detachView() {

    }
}
