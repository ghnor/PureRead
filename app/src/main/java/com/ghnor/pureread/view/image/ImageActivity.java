package com.ghnor.pureread.view.image;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseActivity;
import com.ghnor.pureread.util.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by ghnor on 2016/12/8.
 */

public class ImageActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.photo_view)
    PhotoView mPhotoView;

    public static void openActivity(Context context, String url) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    public void initInject() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        ImageLoader.show(this, getIntent().getStringExtra("url"), mPhotoView);
    }
}
