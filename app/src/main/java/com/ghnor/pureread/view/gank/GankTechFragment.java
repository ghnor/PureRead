package com.ghnor.pureread.view.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseFragment;
import com.ghnor.pureread.config.Constants;
import com.ghnor.pureread.contract.GankTechContract;
import com.ghnor.pureread.entity.GankEntity;
import com.ghnor.pureread.presenter.GankTechPresenter;
import com.ghnor.pureread.view.web.WebActivity;

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

    private String tag = "";

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gank, container, false);
        ButterKnife.bind(this, rootView);
        Log.e(TAG, "onCreateView");
        initData();
        initView();

        return rootView;
    }

    @Override
    protected void initInject() {
        Log.e(TAG, "initInject");
        getFragmentComponent().inject(this);
    }

    @Override
    public void onUserVisibleFirst() {
        super.onUserVisibleFirst();
        Log.e(tag, "onUserVisibleFirst");
        mSwipeRefreshLayout.setRefreshing(true);
        getPresenter().getData();
    }

    private void initData() {
        tag = getArguments().getString("type");
        getPresenter().setType(getArguments().getString("type"));
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mGankTechAdapter =
                new GankTechAdapter(R.layout.item_gank_tech, mGankList));
        mGankTechAdapter.openLoadMore(Constants.PAGE_SIZE);
        mGankTechAdapter.setOnLoadMoreListener(this);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GankEntity entity = ((GankEntity) baseQuickAdapter.getItem(i));
                String url = entity.url;
                String title = entity.desc;
                WebActivity.openActivity(getActivity(), url, title);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        Log.e(tag, "onRefresh");
        getPresenter().getData();
    }

    @Override
    public void onLoadMoreRequested() {
        Log.e(tag, "onLoadMoreRequested");
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
