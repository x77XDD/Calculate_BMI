package com.example.wzbc.bmi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by WZBC on 2018/3/7.
 */

public class SecondActivity extends AppCompatActivity{


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

//    private Button bt1=(Button)findViewById(R.id.calculate);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
//        initViewPager();

    }

//    private void initViewPager() {
//        // 创建一个集合,装填Fragment
//        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
//        mViewPager = (ViewPager)findViewById(R.id.viewpager);
//        ArrayList<Fragment> fragments = new ArrayList<>();
//        // 装填
//        fragments.add(new BlankFragment());
//        fragments.add(new BlankFragment_2());
//        fragments.add(new BlankFragment_3());
//        // 创建ViewPager适配器
//        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
//        myPagerAdapter.setFragments(fragments);
//        // 给ViewPager设置适配器
//        mViewPager.setAdapter(myPagerAdapter);
//        // TabLayout 指示器 (记得自己手动创建4个Fragment,注意是 app包下的Fragment 还是 V4包下的 Fragment)
//        mTabLayout.addTab(mTabLayout.newTab());
//        mTabLayout.addTab(mTabLayout.newTab());
//        mTabLayout.addTab(mTabLayout.newTab());
//        // 使用 TabLayout 和 ViewPager 相关联
//        mTabLayout.setupWithViewPager(mViewPager);
//        // TabLayout指示器添加文本
//        mTabLayout.getTabAt(0).setText("BMI");
//        mTabLayout.getTabAt(1).setText("WHR");
//        mTabLayout.getTabAt(2).setText("FAT PCT");
//    }
//
//    public class MyPagerAdapter extends FragmentPagerAdapter {
//        private List<Fragment> mFragmentList;
//        public void setFragments(ArrayList<Fragment> fragments) {
//            mFragmentList = fragments;
//        }
//        public MyPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//        @Override
//        public Fragment getItem(int position) {
//            Fragment fragment = mFragmentList.get(position);
//            return fragment;
//        }
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//    }
//


}

