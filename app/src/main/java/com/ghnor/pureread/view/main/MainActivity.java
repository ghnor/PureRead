package com.ghnor.pureread.view.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ghnor.pureread.R;
import com.ghnor.pureread.base.BaseActivity;
import com.ghnor.pureread.view.about.AboutActivity;
import com.ghnor.pureread.view.gank.GankMainFragment;
import com.ghnor.pureread.view.weixin.WeixinMainFragment;
import com.ghnor.pureread.view.zhihu.ZhihuMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.frame_layout)
    FrameLayout mFrameLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private GankMainFragment mGankMainFragment;
    private WeixinMainFragment mWeixinMainFragment;
    private ZhihuMainFragment mZhihuMainFragment;

    @Override
    public void initInject() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNavView.setNavigationItemSelectedListener(this);

        initFragment();

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
    }

    private void initFragment() {
        if (mGankMainFragment == null) {
            mGankMainFragment = GankMainFragment.newInstance();
        }

        if (mWeixinMainFragment == null) {
            mWeixinMainFragment = WeixinMainFragment.newInstance();
        }

        if (mZhihuMainFragment == null) {
            mZhihuMainFragment = ZhihuMainFragment.newInstance();
        }

        replaceFragment(GankMainFragment.TAG);
    }

    private void replaceFragment(String fragmentTag) {
        switch (fragmentTag) {
            case GankMainFragment.TAG:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        mGankMainFragment, GankMainFragment.TAG).commit();
                break;
            case WeixinMainFragment.TAG:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        mWeixinMainFragment, WeixinMainFragment.TAG).commit();
                break;
            case ZhihuMainFragment.TAG:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        mZhihuMainFragment, ZhihuMainFragment.TAG).commit();
                break;
            default:
                break;
        }
    }

    private void toggleDrawer() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                toggleDrawer();
                return true;
            case R.id.action_about:
                AboutActivity.openActivity(MainActivity.this);
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_gank:
                replaceFragment(GankMainFragment.TAG);
                break;
            case R.id.nav_weixin:
                replaceFragment(WeixinMainFragment.TAG);
                break;
            case R.id.nav_zhihu:
                replaceFragment(ZhihuMainFragment.TAG);
                break;
            case R.id.nav_about:
                AboutActivity.openActivity(MainActivity.this);
                break;
            default:
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
