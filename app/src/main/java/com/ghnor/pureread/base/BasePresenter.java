package com.ghnor.pureread.base;

import android.support.annotation.NonNull;

/**
 * Created by ghnor on 2016/11/6.
 */

public interface BasePresenter<T extends BaseView> {

    void onCreate();

    void onDestroy();

    void attachView(@NonNull T view);

    void detachView();
}
