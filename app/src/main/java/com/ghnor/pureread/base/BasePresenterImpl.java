package com.ghnor.pureread.base;

import android.support.annotation.NonNull;

/**
 * Created by ghnor on 2016/11/6.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    private T mView;

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(@NonNull T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    protected T getView() {
        return mView;
    }
}
