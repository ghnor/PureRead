package com.ghnor.pureread.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghnor.pureread.App;
import com.ghnor.pureread.di.component.DaggerFragmentComponent;
import com.ghnor.pureread.di.component.FragmentComponent;
import com.ghnor.pureread.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by ghnor on 2016/10/25.
 */

public abstract class BaseFragment<T extends BasePresenter> extends LazyFragment implements BaseView {

    private FragmentComponent mFragmentComponent;

    @Inject
    protected T mPresenter;

    protected abstract void initInject();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentComponent();
        initInject();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter == null) return;
        mPresenter.attachView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    private void initFragmentComponent() {
        mFragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    protected FragmentComponent getFragmentComponent(){
        return mFragmentComponent;
    }

    protected T getPresenter() {
        return mPresenter;
    }

}
