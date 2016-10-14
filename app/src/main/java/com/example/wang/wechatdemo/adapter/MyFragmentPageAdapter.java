package com.example.wang.wechatdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wang on 16/7/25.
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private List<String> titleList;
    private Context context;
    private List<Fragment> fragments;

    public MyFragmentPageAdapter(FragmentManager fm, List<String> titleList, Context context, List<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.titleList = titleList;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}

