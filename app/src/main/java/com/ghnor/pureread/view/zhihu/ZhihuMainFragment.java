package com.ghnor.pureread.view.zhihu;

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

public class ZhihuMainFragment extends BaseFragment {

    public static final String TAG = "ZhihuMainFragment";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static ZhihuMainFragment newInstance() {
        return new ZhihuMainFragment();
    }

    @Override
    protected void initInject() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zhihu_main, container, false);
        ButterKnife.bind(this, rootView);

        mToolbar.setNavigationIcon(ContextCompat.getDrawable(getActivity(), R.drawable.ic_drawer));
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

        return rootView;
    }
}
