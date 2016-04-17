package com.debug8.viewpagerfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList;
    private TextView[] textViews = new TextView[6];
    private Fragment[] fragments = new Fragment[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initTextView();
        initViewPager();
    }



    private void initTextView(){
        textViews[0] = (TextView) findViewById(R.id.textView1);
        textViews[1] = (TextView) findViewById(R.id.textView2);
        textViews[2] = (TextView) findViewById(R.id.textView3);
        textViews[3] = (TextView) findViewById(R.id.textView4);
        textViews[4] = (TextView) findViewById(R.id.textView5);
        textViews[5] = (TextView) findViewById(R.id.textView6);
        for(int i = 0; i < 6; i++){
            textViews[i].setOnClickListener(new TextViewListener(i));
        }

    }

    public class TextViewListener implements  View.OnClickListener{
        private int index = 0;

        public TextViewListener(int index){
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
            textViewChangeTextColor(index);

        }
    }

    private void initViewPager(){
        viewPager = (ViewPager)findViewById(R.id.viewpager);

        fragments[0] = new FirstFragment();
        fragments[1] = new FirstFragment();
        fragments[2] = new SecondFragment();
        fragments[3] = new ThirdFragment();
        fragments[4] = new FourthFragment();
        fragments[5] = new FifthFragment();


        fragmentList = new ArrayList<Fragment>();
        for(Fragment fragment : fragments){
            fragmentList.add(fragment);
        }

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),fragmentList));
        viewPager.setCurrentItem(0);
        textViewChangeTextColor(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> list;

        public MyViewPagerAdapter(FragmentManager manager,ArrayList<Fragment> list){
            super(manager);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{


        @Override
        public void onPageSelected(int position) {
            textViewChangeTextColor(position);


        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private void textViewChangeTextColor(int index){
        for(TextView tv : textViews){
            tv.setTextColor(Color.BLUE);
        }
        textViews[index].setTextColor(Color.RED);

    }
}
