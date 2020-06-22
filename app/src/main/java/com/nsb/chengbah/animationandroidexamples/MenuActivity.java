package com.nsb.chengbah.animationandroidexamples;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nsb.chengbah.animationandroidexamples.fragment.PropertyAnimationFragment;
import com.nsb.chengbah.animationandroidexamples.fragment.ViewAnimationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity implements ViewAnimationFragment.OnFragmentInteractionListener, PropertyAnimationFragment.OnFragmentInteractionListener {

    private static final String TAG = "hcb";
    private BottomNavigationView navigation;
    private Fragment[] mFragments = new Fragment[2];
    private int mPreFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.view_animation:
                    showAndHideFragment(mFragments[0], mFragments[mPreFragment]);
                    mPreFragment = 0;
                    return true;
                case R.id.property_animation:
                    showAndHideFragment(mFragments[1], mFragments[mPreFragment]);
                    mPreFragment = 1;
                    return true;
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    private void showAndHideFragment(Fragment mShowFragment, Fragment mHideFragment) {
        Log.d(TAG, "showFragment is " + mShowFragment.getClass().getName() + " hideFragment is " + mHideFragment.getClass().getName());
        if (mShowFragment != mHideFragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(mHideFragment);
            transaction.show(mShowFragment);
            transaction.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initView();
        initFragment();
        initEvent();

    }

    private void initFragment() {
        mFragments[0] = new ViewAnimationFragment();
        mFragments[1] = new PropertyAnimationFragment();
        initLoadFragment(R.id.fragment_content, 0, mFragments);
        mPreFragment = 0;
    }

    /**
     * @param fragment_content_id FrameLayout ID
     * @param showFragment        show
     * @param mFragments          hide
     */
    private void initLoadFragment(int fragment_content_id, int showFragment, Fragment[] mFragments) {
        //获取到FragmentManager实例的同时去开启事物
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.length; i++) {
            //首先将Fragment添加到事务中
            transaction.add(fragment_content_id, mFragments[i], mFragments[i].getClass().getName());

            //默认展示 mFragments[showFragment]
            //这里做首次Fragment的展示，如果不是指定的Fragment就先隐藏，需要的时候再显示出来
            if (i != showFragment) {
                transaction.hide(mFragments[i]);
            }
        }

        //提交事务
        transaction.commit();
    }

    private void initEvent() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initView() {
        navigation = findViewById(R.id.navigation);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
