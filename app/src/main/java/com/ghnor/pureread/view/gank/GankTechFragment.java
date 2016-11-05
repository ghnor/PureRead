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
import com.ghnor.pureread.R;
import com.ghnor.pureread.api.GankApis;
import com.ghnor.pureread.base.BaseLazyFragment;
import com.ghnor.pureread.entity.BaseEntity;
import com.ghnor.pureread.entity.GankEntity;
import com.ghnor.pureread.util.ServiceRequester;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ghnor on 2016/10/22.
 */

public class GankTechFragment extends BaseLazyFragment
        implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    public static final String TAG = "GankTechFragment";
    public static final String ALL = "all";
    public static final String ANDROID = "Android";
    public static final String IOS = "iOS";
    public static final String WEB = "前端";
    public static final String EXPEND = "拓展资源";
    public static final String RELAX = "休息视频";

    private String mType; //当前界面需要显示的类型
    private int mPageIndex = 1;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<GankEntity> mGankList;
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
    protected void onFirstUserVisible() {
        super.onFirstUserVisible();
        requestService(mPageIndex);
    }

    private void initData() {
        mGankList = new ArrayList<>();
        mType = getArguments().getString("type");
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mGankTechAdapter =
                new GankTechAdapter(R.layout.item_gank_tech, mGankList));
        mGankTechAdapter.setOnLoadMoreListener(this);

        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setRefreshing(true);
    }

    private void requestService(int pageIndex) {
        GankApis gankApis = ServiceRequester.getGankAll();
        gankApis.getGankTechList(mType, 20, pageIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseEntity<List<GankEntity>>>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "请求服务器onCompleted");
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "请求服务器onError\n" + e.toString());
                    }

                    @Override
                    public void onNext(BaseEntity<List<GankEntity>> listBaseEntity) {
                        mGankTechAdapter.addData(listBaseEntity.results);
                    }
                });
    }

    @Override
    public void onRefresh() {
        mPageIndex = 1;
        requestService(mPageIndex);
    }

    @Override
    public void onLoadMoreRequested() {
        mPageIndex++;
        requestService(mPageIndex);
    }
}
