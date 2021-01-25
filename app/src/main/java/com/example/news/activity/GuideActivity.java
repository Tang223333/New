package com.example.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.news.R;
import com.example.news.SplashActivity;
import com.example.news.utils.CenterUtil;
import com.example.news.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mGuideVp;
    private Button mGuideBtn;
    private LinearLayout mGuideLl;
    private ImageView mGuideDian;
    private List<ImageView> imageViewList;
    private int leftMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mGuideVp = (ViewPager) findViewById(R.id.guide_vp);
        mGuideBtn = (Button) findViewById(R.id.guide_btn);
        mGuideLl = (LinearLayout) findViewById(R.id.guide_ll);
        mGuideDian = (ImageView) findViewById(R.id.guide_dian);

        int[] ints=new int[]{
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };

        imageViewList=new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(ints[i]);
            imageViewList.add(imageView);

            imageView=new ImageView(this);
            imageView.setBackgroundResource(R.drawable.dian_normal);
            int px= DensityUtil.dip2px(GuideActivity.this,10);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(px,px);
            if (i > 0){
                layoutParams.leftMargin=px;
            }
            imageView.setLayoutParams(layoutParams);
            mGuideLl.addView(imageView);
        }

        mGuideVp.setAdapter(new MyPagerAdapter());

        mGuideLl.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

        mGuideVp.addOnPageChangeListener(new MyOnPageChangeListener());

        mGuideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CenterUtil.setBoolean(GuideActivity.this,SplashActivity.SELECT_MAIN,true);
                Intent intent=new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 滑动时调用
         * @param position 位置
         * @param positionOffset 滑动百分比
         * @param positionOffsetPixels 滑动像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //点移动距离=屏幕百分比*点的间距+点原来与左边的距离
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mGuideDian.getLayoutParams();
            layoutParams.leftMargin=(int) (position*leftMax+(positionOffset*leftMax));
            mGuideDian.setLayoutParams(layoutParams);
        }

        /**
         * 选中页面
         * @param position 位置
         */
        @Override
        public void onPageSelected(int position) {
            if (position == imageViewList.size()-1){
                mGuideBtn.setVisibility(View.VISIBLE);
            }else {
                mGuideBtn.setVisibility(View.GONE);
            }
        }

        /**
         * 当ViewPager页面滑动状态发生变化时调用
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        @Override
        public void onGlobalLayout() {
            mGuideLl.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            leftMax = mGuideLl.getChildAt(1).getLeft()-mGuideLl.getChildAt(0).getLeft();
            Log.d("TAG", "initView: "+leftMax);
        }
    }

    class MyPagerAdapter extends PagerAdapter{

        /**
         * 总数
         * @return
         */
        @Override
        public int getCount() {
            return imageViewList.size();
        }

        /**
         * 相当于其他adapter中的getView
         * @param container ViewPager的容器
         * @param position 位置
         * @return
         */
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView=imageViewList.get(position);
            container.addView(imageView);
//            return position;
            return imageView;
        }

        /**
         *
         * @param view 当前视图
         * @param object instantiateItem方法的返回值
         * @return
         */
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//            return view==imageViewList.get((Integer) object);
            return view==object;
        }


        /**
         *
         * @param container ViewPager的容器
         * @param position 位置
         * @param object instantiateItem方法的返回值
         */
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
//            container.removeView(imageViewList.get((Integer) object));
//            container.removeView(imageViewList.get(position));
            container.removeView((View) object);
        }
    }
}