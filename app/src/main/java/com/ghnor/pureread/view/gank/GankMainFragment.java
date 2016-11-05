package com.ghnor.pureread.view.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ghnor on 2016/10/22.
 */

public class GankMainFragment extends BaseFragment {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    public static String TAG = "GankMainFragment";

    private GankTechFragment mGankTechAllFragment;
    private GankTechFragment mGankTechAndroidFragment;
    private GankTechFragment mGankTechIosFragment;
    private GankTechFragment mGankTechWebFragment;
    private GankTechFragment mGankTechExpendFragment;
    private GankTechFragment mGankTechRelaxFragment;
    private GankGirlFragment mGankGirlFragment;
    private GankMainPagerAdapter mGankMainPagerAdapter;

    public static GankMainFragment newInstance() {
        return new GankMainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gank_main, container, false);
        ButterKnife.bind(this, view);

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initFragment();
        initViewPager();

        return view;
    }

    private void initFragment() {
        mGankTechAllFragment = GankTechFragment.newInstance(GankTechFragment.ALL);
        mGankTechAndroidFragment = GankTechFragment.newInstance(GankTechFragment.ANDROID);
        mGankTechIosFragment = GankTechFragment.newInstance(GankTechFragment.IOS);
        mGankTechWebFragment = GankTechFragment.newInstance(GankTechFragment.WEB);
        mGankTechExpendFragment = GankTechFragment.newInstance(GankTechFragment.EXPEND);
        mGankTechRelaxFragment = GankTechFragment.newInstance(GankTechFragment.RELAX);
        mGankGirlFragment = GankGirlFragment.newInstance();
    }

    private void initViewPager() {
        mGankMainPagerAdapter = new GankMainPagerAdapter(getChildFragmentManager());
        mGankMainPagerAdapter.addItem(mGankTechAllFragment, "全部");
        mGankMainPagerAdapter.addItem(mGankTechAndroidFragment, "Android");
        mGankMainPagerAdapter.addItem(mGankTechIosFragment, "iOS");
        mGankMainPagerAdapter.addItem(mGankTechWebFragment, "前端");
        mGankMainPagerAdapter.addItem(mGankTechExpendFragment, "拓展资源");
        mGankMainPagerAdapter.addItem(mGankTechRelaxFragment, "休息视频");
        mGankMainPagerAdapter.addItem(mGankGirlFragment, "福利");
        mViewPager.setAdapter(mGankMainPagerAdapter);
        mViewPager.setOffscreenPageLimit(6);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
