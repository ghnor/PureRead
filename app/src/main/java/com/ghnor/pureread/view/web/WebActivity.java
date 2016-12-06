package com.ghnor.pureread.view.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseActivity;
import com.ghnor.pureread.util.ClipboardUtil;
import com.ghnor.pureread.util.IntentUtil;
import com.ghnor.pureread.util.ShareUtil;
import com.ghnor.pureread.widget.X5WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ghnor on 2016/11/13.
 */

public class WebActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web_view)
    X5WebView mWebView;

    public static void openActivity(Context context, String url, String title) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("title"));
        mWebView.loadUrl(intent.getStringExtra("url"));
    }

    @Override
    public void initInject() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_copy:
                ClipboardUtil.copy(WebActivity.this, mWebView.getUrl());
                return true;
            case R.id.menu_share:
                ShareUtil.share(WebActivity.this, mWebView.getUrl());
                return true;
            case R.id.menu_open_browser:
                IntentUtil.openBrowser(WebActivity.this, mWebView.getUrl());
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
