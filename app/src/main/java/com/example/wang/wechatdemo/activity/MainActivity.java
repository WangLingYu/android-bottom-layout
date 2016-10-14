package com.example.wang.wechatdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.wang.wechatdemo.R;
import com.example.wang.wechatdemo.adapter.MyFragmentPageAdapter;
import com.example.wang.wechatdemo.fragment.FindFragment;
import com.example.wang.wechatdemo.fragment.MineFragment;
import com.example.wang.wechatdemo.fragment.PhoneFragment;
import com.example.wang.wechatdemo.fragment.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    RadioGroup bottomRadioGroup;
    RadioButton weChatBt, phoneBt, findBt, mineBt;
    ViewPager mViewPager;
    TabLayout tabLayout;
    MyFragmentPageAdapter myFragmentPageAdapter;
    List<Fragment> fragments;
    List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initData();
        initView();
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new WeChatFragment());
        fragments.add(new PhoneFragment());
        fragments.add(new FindFragment());
        fragments.add(new MineFragment());
        titles = new ArrayList<>();
        titles.add("微信");
        titles.add("通讯录");
        titles.add("发现");
        titles.add("我");
    }

    private void initView() {
        myFragmentPageAdapter = new MyFragmentPageAdapter(
                getSupportFragmentManager(), titles, this, fragments);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager.setAdapter(myFragmentPageAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        bottomRadioGroup = (RadioGroup) findViewById(R.id.bottom_tab);
        weChatBt = (RadioButton) findViewById(R.id.bottom_tab_wechat_bt);
        phoneBt = (RadioButton) findViewById(R.id.bottom_tab_phone_bt);
        findBt = (RadioButton) findViewById(R.id.bottom_tab_find_bt);
        mineBt = (RadioButton) findViewById(R.id.bottom_tab_mine_bt);
        bottomRadioGroup.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    //点击底部导航栏进行viewPager的同步滑动
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.bottom_tab_wechat_bt:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.bottom_tab_phone_bt:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.bottom_tab_find_bt:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.bottom_tab_mine_bt:
                mViewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    //进行滑动完毕后进行底部导航栏的同步点击
    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (mViewPager.getCurrentItem()) {
                case 0:
                    weChatBt.setChecked(true);
                    break;
                case 1:
                    phoneBt.setChecked(true);
                    break;
                case 2:
                    findBt.setChecked(true);
                    break;
                case 3:
                    mineBt.setChecked(true);
                    break;
            }
        }
    }
}

