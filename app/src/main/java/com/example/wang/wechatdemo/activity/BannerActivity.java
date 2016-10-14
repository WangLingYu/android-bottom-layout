package com.example.wang.wechatdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wang.wechatdemo.R;
import com.youth.banner.Banner;

public class BannerActivity extends AppCompatActivity {
    private Banner banner;
    String[] images = new String[]{
            "http://f.hiphotos.baidu.com/zhidao/pic/item/d058ccbf6c81800acc536e1bb53533fa828b4775.jpg",
            "http://img02.tooopen.com/images/20150703/tooopen_sy_132761691991.jpg",
            "http://pic40.nipic.com/20140402/18347945_093840502196_2.jpg",
            "http://img5.duitang.com/uploads/item/201407/22/20140722002809_ntLC3.jpeg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        banner = (Banner) findViewById(R.id.banner);
        assert banner != null;
//        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
//
//        banner.setIndicatorGravity(Banner.CENTER);
//        banner.isAutoPlay(false);
//        banner.setImages(images, new Banner.OnLoadImageListener() {
//            @Override
//            public void OnLoadImage(ImageView view, Object url) {
//                Glide.with(getApplicationContext())
//                        .load(url)
//                        .into(view);
//            }
//        });
//
//        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
//            @Override
//            public void OnBannerClick(View view, int position) {
//                if (position == 4) {
//                    startActivity(new Intent(BannerActivity.this, MainActivity.class));
//                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//                }
//            }
//        });

    }

    @Override
    public void onStart() {
        super.onStart();
        //在页面可见时开始轮播，
        //默认的是页面初始化时就开始轮播了，如果你不需要可以再onCreate方法里设置banner.isAutoPlay(false);
        banner.isAutoPlay(true);
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.isAutoPlay(false);
    }
}
