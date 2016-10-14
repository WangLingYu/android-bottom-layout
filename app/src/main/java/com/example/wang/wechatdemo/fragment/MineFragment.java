package com.example.wang.wechatdemo.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wang.wechatdemo.R;

/**
 * Created by wang on 16/7/25.
 */
public class MineFragment extends Fragment {
    TextView textView;
    RelativeLayout relativeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        setTxAnimation();

        return view;
    }


    private void initView(View view) {
        textView = (TextView) view.findViewById(R.id.textView);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.mine_layout);
    }

    private void setTxAnimation() {
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());//设置加速器，这个是两头慢中间快的效果
        animatorSet.setDuration(3000).start();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(textView, "rotationX", 0, 360), //旋转动画，从开始的0度转360停下
                ObjectAnimator.ofFloat(textView, "rotationY", 0, 360),
                ObjectAnimator.ofFloat(textView, "rotation", 0, 360),
                ObjectAnimator.ofFloat(textView, "translationX", 0, -150), //位移动画 从当前位置水平移动90dp
                ObjectAnimator.ofFloat(textView, "translationY", 0, -350),
                ObjectAnimator.ofFloat(textView, "scaleX", 1, 1), //缩放动画  将水平宽度缩放到多少
                ObjectAnimator.ofFloat(textView, "scaleY", 1, 1),
                ObjectAnimator.ofFloat(textView, "alpha", 1, 0.5f, 0));
        animatorSet.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator.ofFloat(textView, "alpha", 0, 1).start();
                textView.setText("我是曹钰，我是傻狗!!");
                textView.setTextSize(25);
                textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            }
        });
    }
}
