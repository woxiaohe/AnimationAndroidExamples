package com.nsb.chengbah.animationandroidexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nsb.chengbah.animationandroidexamples.adapter.ViewPagerAdapter;
import com.nsb.chengbah.animationandroidexamples.fragment.PropertyAnimationFragment;
import com.nsb.chengbah.animationandroidexamples.fragment.PropertyValuesHolderFragment;
import com.nsb.chengbah.animationandroidexamples.fragment.ViewAnimationFragment;

public class HomeActivity extends AppCompatActivity implements ViewAnimationFragment.OnFragmentInteractionListener ,PropertyAnimationFragment.OnFragmentInteractionListener,PropertyValuesHolderFragment.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initEvent();
    }

    private void initEvent() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.view_animation:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.property_animation:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(2);
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
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        viewPager = findViewById(R.id.viewpage);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        initViewPager(viewPager);
    }

    private void initViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFrgment(new ViewAnimationFragment());
        adapter.addFrgment(new PropertyAnimationFragment());
        adapter.addFrgment(new PropertyValuesHolderFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
