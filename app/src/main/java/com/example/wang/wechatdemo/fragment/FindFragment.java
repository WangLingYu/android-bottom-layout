package com.example.wang.wechatdemo.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;

import com.example.wang.wechatdemo.R;


/**
 * Created by wang on 16/7/25.
 */
public class FindFragment extends Fragment {
    View mView;
    ImageButton imageButton, imageButton1, imageButton2, imageButton3, imageButton4;
    boolean isExpand = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_find, container, false);
        initView(mView);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExpand) {
                    Log.d("FindFragment","展开了");
                    startAnim();
                    isExpand = true;
                } else {
                    closeAnim();
                    Log.d("FindFragment","合拢了");
                    isExpand = false;
                }

            }
        });
        return mView;
    }

    private void initView(View view) {
        imageButton = (ImageButton) view.findViewById(R.id.bt1);
        imageButton1 = (ImageButton) view.findViewById(R.id.bt2);
        imageButton2 = (ImageButton) view.findViewById(R.id.bt3);
        imageButton3 = (ImageButton) view.findViewById(R.id.bt4);
        imageButton4 = (ImageButton) view.findViewById(R.id.bt5);
    }

    private void startAnim() {

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(imageButton4, "alpha", 1F, 0.5F),
                ObjectAnimator.ofFloat(imageButton1, "translationY", 350F),
                ObjectAnimator.ofFloat(imageButton2, "translationY", -350F),
                ObjectAnimator.ofFloat(imageButton3, "translationX", 350F),
                ObjectAnimator.ofFloat(imageButton, "translationX", -350F)
        );
        animatorSet.start();
    }

    private void closeAnim() {

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(imageButton4, "alpha", 0.5F, 1F),
                ObjectAnimator.ofFloat(imageButton1, "translationY", 0),
                ObjectAnimator.ofFloat(imageButton2, "translationY", 0),
                ObjectAnimator.ofFloat(imageButton3, "translationX", 0),
                ObjectAnimator.ofFloat(imageButton, "translationX", 0)
        );
        animatorSet.start();
    }

}
