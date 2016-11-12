package com.ghnor.pureread.presenter;

import com.ghnor.pureread.api.GankApis;
import com.ghnor.pureread.base.BasePresenterImpl;
import com.ghnor.pureread.contract.GankTechContract;
import com.ghnor.pureread.entity.GankEntity;
import com.ghnor.pureread.entity.ServiceResponse;
import com.ghnor.pureread.util.ServiceRequester;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ghnor on 2016/11/6.
 */

public class GankTechPresenter extends BasePresenterImpl<GankTechContract.View> implements GankTechContract.Presenter {

    private String mType; //当前界面需要显示的类型

    private int mPageIndex;

    @Inject
    public GankTechPresenter() {}

    @Override
    public void getData() {
        mPageIndex = 1;
        requestService(mPageIndex, new Subscriber<ServiceResponse<List<GankEntity>>>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onNext(ServiceResponse<List<GankEntity>> listBaseEntity) {
                getView().showContent(listBaseEntity.results);
            }
        });
    }

    @Override
    public void getDataMore() {
        mPageIndex++;
        requestService(mPageIndex, new Subscriber<ServiceResponse<List<GankEntity>>>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onNext(ServiceResponse<List<GankEntity>> listBaseEntity) {
                getView().showContentMore(listBaseEntity.results);
            }
        });
    }

    @Override
    public void setType(String type) {
        mType = type;
    }

    private void requestService(int pageIndex, Subscriber subscriber) {
        GankApis gankApis = ServiceRequester.getGankAll();
        gankApis.getGankTechList(mType, 20, pageIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
