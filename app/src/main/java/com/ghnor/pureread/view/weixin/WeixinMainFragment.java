package com.ghnor.pureread.view.weixin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ghnor on 2016/11/19.
 */

public class WeixinMainFragment extends BaseFragment {

    public static final String TAG = "WeixinMainFragment";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static WeixinMainFragment newInstance() {
        return new WeixinMainFragment();
    }

    @Override
    protected void initInject() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weixin_main, container, false);
        ButterKnife.bind(this, rootView);

        mToolbar.setNavigationIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_drawer));
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

        return rootView;
    }
}
