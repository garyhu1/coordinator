package com.garyhu.coordinator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.garyhu.coordinator.R;
import com.garyhu.coordinator.fragment.CorFragment;
import com.garyhu.coordinator.widget.CoordinatorTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： garyhu.
 * 时间： 2017/2/8.
 */

public class CoordinatorActivity extends AppCompatActivity {

    private CoordinatorTabLayout coordinatorTabLayout;
    private ViewPager vp;
    private String[] mTitles = {"头条","微信","微博","新浪"};
    private int[] imgs,colors;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cor);
        coordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.cor_layout);
        vp = (ViewPager) findViewById(R.id.vp);
//        imgs = new int[]{R.drawable.img1,
//                R.drawable.img3,R.drawable.img5,R.drawable.img6};
        imgs = new int[]{
                R.mipmap.bg_android,
                R.mipmap.bg_ios,
                R.mipmap.bg_js,
                R.mipmap.bg_other};
        colors = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light
        };
        initFragments();
        initView();
        coordinatorTabLayout.setTitle("garyhu")
                .setBackEnable(false)
                .setImageArray(imgs,colors)
                .setupWithViewPager(vp);
    }

    public void initFragments(){
        fragments = new ArrayList<>();
        for (String title:mTitles) {
            fragments.add(CorFragment.getInstance(title));
        }
    }

    public void initView(){
        vp.setOffscreenPageLimit(4);
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments!=null?fragments.size():0;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
