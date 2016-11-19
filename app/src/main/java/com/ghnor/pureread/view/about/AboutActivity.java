package com.ghnor.pureread.view.about;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseActivity;
import com.ghnor.pureread.util.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ghnor on 2016/11/19.
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.version)
    TextView mVersion;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, AboutActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void initInject() {

    }

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        String version = String.format(getResources().getString(R.string.version),
                AppUtil.getVersionName(this));
        mVersion.setText(version);
    }
}
