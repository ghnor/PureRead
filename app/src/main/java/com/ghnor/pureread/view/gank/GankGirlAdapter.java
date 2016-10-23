package com.ghnor.pureread.view.gank;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ghnor.pureread.R;
import com.ghnor.pureread.entity.GankEntity;
import com.ghnor.pureread.util.ImageLoader;

import java.util.List;

/**
 * Created by ghnor on 2016/10/23.
 */

public class GankGirlAdapter extends BaseQuickAdapter<GankEntity> {

    public GankGirlAdapter(int layoutResId, List<GankEntity> data) {
        super(layoutResId, data);
    }

    public GankGirlAdapter(List<GankEntity> data) {
        super(data);
    }

    public GankGirlAdapter(View contentView, List<GankEntity> data) {
        super(contentView, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, GankEntity gankEntity) {
        ImageLoader.show(mContext, gankEntity.url, (ImageView) baseViewHolder.getView(R.id.imgv));
    }
}
