package com.ghnor.pureread.contract;

import com.ghnor.pureread.base.BasePresenter;
import com.ghnor.pureread.base.BaseView;
import com.ghnor.pureread.entity.GankEntity;

import java.util.List;

/**
 * Created by ghnor on 2016/11/6.
 */

public interface GankTechContract {
    interface View extends BaseView {

        void showContent(List<GankEntity> list);

        void showContentMore(List<GankEntity> list);
    }

    interface Presenter extends BasePresenter<View> {

        void getData();

        void getDataMore();

        void setType(String type);
    }
}
