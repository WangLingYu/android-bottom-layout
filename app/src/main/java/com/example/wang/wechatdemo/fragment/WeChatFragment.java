package com.example.wang.wechatdemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wang.wechatdemo.R;
import com.example.wang.wechatdemo.customview.TimeView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        final TimeView timeView = (TimeView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        new Runnable() {
            @Override
            public void run() {
                Log.d("WeChatFragment", "run执行了");
                Log.d("WeChatFragment", "重新绘制了");
                timeView.requestLayout();
                handler.postDelayed(this, 10);
            }
        }.run();
        return view;
    }


    static class ViewWrapper {
        private View mTargetView;

        public ViewWrapper(View mTargetView) {
            this.mTargetView = mTargetView;
        }

        public int getmTargetView() {
            return mTargetView.getLayoutParams().width;
        }

        public void setmTargetView(int width) {
            mTargetView.getLayoutParams().width = width;
            mTargetView.requestLayout();
        }
    }

}

