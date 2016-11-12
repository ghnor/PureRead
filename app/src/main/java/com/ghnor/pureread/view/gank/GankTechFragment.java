package com.ghnor.pureread.view.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseFragment;
import com.ghnor.pureread.contract.GankTechContract;
import com.ghnor.pureread.entity.GankEntity;
import com.ghnor.pureread.presenter.GankTechPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ghnor on 2016/10/22.
 */

public class GankTechFragment extends BaseFragment<GankTechPresenter>
        implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener,
        GankTechContract.View{

    public static final String TAG = "GankTechFragment";
    public static final String ALL = "all";
    public static final String ANDROID = "Android";
    public static final String IOS = "iOS";
    public static final String WEB = "前端";
    public static final String EXPEND = "拓展资源";
    public static final String RELAX = "休息视频";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<GankEntity> mGankList = new ArrayList<>();;
    private GankTechAdapter mGankTechAdapter;

    public static GankTechFragment newInstance(String type) {
        GankTechFragment gankTechFragment = new GankTechFragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        gankTechFragment.setArguments(args);
        return gankTechFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gank, container, false);
        ButterKnife.bind(this, rootView);

        initData();
        initView();

        return rootView;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onUserVisibleFirst() {
        super.onUserVisibleFirst();
        getPresenter().getData();
    }

    private void initData() {
        getPresenter().setType(getArguments().getString("type"));
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mGankTechAdapter =
                new GankTechAdapter(R.layout.item_gank_tech, mGankList));
        mGankTechAdapter.setOnLoadMoreListener(this);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        getPresenter().getData();
    }

    @Override
    public void onLoadMoreRequested() {
        getPresenter().getDataMore();
    }

    @Override
    public void showContent(List<GankEntity> list) {
        mSwipeRefreshLayout.setRefreshing(false);
        mGankTechAdapter.setNewData(list);
    }

    @Override
    public void showContentMore(List<GankEntity> list) {
        mGankTechAdapter.addData(list);
    }
}
