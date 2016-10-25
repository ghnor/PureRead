package com.ghnor.pureread.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ghnor on 2016/10/22.
 */

public class BaseLazyFragment extends BaseFragment {

    private static final String TAG = BaseLazyFragment.class.getSimpleName();

    private boolean isPrepared;

    // 第一次onResume中的调用onUserVisible避免操作与onFirstUserVisible操作重复
    private boolean isFirstResume = true;

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");
        initPrepare();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        if (getUserVisibleHint()) {
            onUserVisible();
            if (isFirstResume) {
                isFirstResume = false;
                onFirstUserVisible();
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        if (!getUserVisibleHint()) {
            onUserInvisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, "setUserVisibleHint"+isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                if (isPrepared) {
                    onFirstUserVisible();
                    onUserVisible();
                }
            } else {
                if (isPrepared) {
                    onUserVisible();
                }
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                if (isPrepared) {
                    onFirstUserInvisible();
                    onUserInvisible();
                }
            } else {
                if (isPrepared) {
                    onUserInvisible();
                }
            }
        }
    }

    private synchronized void initPrepare() {
        if (!isPrepared) {
            isPrepared = true;
        }
    }

    /**************************************protected method************************************/
    /**
     * 第一次fragment可见（进行初始化工作）
     */
    protected void onFirstUserVisible() {}

    /**
     * fragment可见（切换回来或者onResume）
     */
    protected void onUserVisible() {}

    /**
     * 第一次fragment不可见（不建议在此处理事件）
     */
    protected void onFirstUserInvisible() {}

    /**
     * fragment不可见（切换掉或者onPause）
     */
    protected void onUserInvisible() {}
}
