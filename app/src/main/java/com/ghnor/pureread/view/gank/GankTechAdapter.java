package com.ghnor.pureread.view.gank;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ghnor.pureread.R;
import com.ghnor.pureread.entity.GankEntity;

import java.util.List;

/**
 * Created by ghnor on 2016/10/23.
 */

public class GankTechAdapter extends BaseQuickAdapter<GankEntity> {
    public GankTechAdapter(int layoutResId, List<GankEntity> data) {
        super(layoutResId, data);
    }

    public GankTechAdapter(List<GankEntity> data) {
        super(data);
    }

    public GankTechAdapter(View contentView, List<GankEntity> data) {
        super(contentView, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, GankEntity gankEntity) {
        baseViewHolder.setText(R.id.tv_desc, gankEntity.desc);
        baseViewHolder.setText(R.id.tv_author, gankEntity.who);
        baseViewHolder.setText(R.id.tv_time, gankEntity.publishedAt);
        baseViewHolder.setText(R.id.tv_type, gankEntity.type);
    }
}
