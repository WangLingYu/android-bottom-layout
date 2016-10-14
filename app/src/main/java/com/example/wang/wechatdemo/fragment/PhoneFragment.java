package com.example.wang.wechatdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RadioGroup;

import com.example.wang.wechatdemo.adapter.MyRecyclerAdapter;
import com.example.wang.wechatdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 16/7/25.
 */
public class PhoneFragment extends Fragment {

    View mView;
    RecyclerView mRecyclerView;
    RadioGroup radioGroup;
    int lastX, lastY;
    boolean isFirstItemVisible = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_phone, container, false);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add("测试数据" + i);
        }
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.phone_recycler);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(strings);
        mRecyclerView.setAdapter(myRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        radioGroup = (RadioGroup) getActivity().findViewById(R.id.bottom_tab);
        setViewListener();
        return mView;
    }

    private void setViewListener() {


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findFirstVisibleItemPosition();
                if (firstVisibleItem == 0) {
//                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(radioGroup, "translationY", lastY,
//                           -100);
//                    objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//                    objectAnimator.setDuration(500).start();
                    radioGroup.animate().translationY(radioGroup.getHeight()).setInterpolator(new AccelerateInterpolator(2));
                    isFirstItemVisible = true;
                }
            }
        });
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) event.getX();
                        lastY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("lastY", String.valueOf(lastY));
                        if (event.getY() - lastY > 20 && !isFirstItemVisible) { //向上滑动
//                            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(radioGroup, "translationY", lastY, lastY - radioGroup.getHeight());
//                            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//                            objectAnimator.setDuration(500).start();
                            radioGroup.animate().translationY(0).setInterpolator(new AccelerateInterpolator());
                            if (event.getY() - lastY < -20 && !isFirstItemVisible) {//向下滑动
                                radioGroup.animate().translationY(radioGroup.getHeight()).setInterpolator(new AccelerateInterpolator());
                            }

                            lastX = (int) event.getX();
                            lastY = (int) event.getY();
                            isFirstItemVisible = true;
                        }
                        break;
                }
                return false;
            }
        });
    }
}
