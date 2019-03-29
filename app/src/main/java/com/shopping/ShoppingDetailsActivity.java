package com.shopping;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.fragment.MainFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/26.
 *
 */

public class ShoppingDetailsActivity  extends AppCompatActivity
                              implements MainFragment.TabBarListener {

    private MagicIndicator magicIndicator;

    private List<String> list = new ArrayList<>();

    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList();

    private FrameLayout frameLayout;

    // fg
    private MainFragment mainFragment;
    private FragmentPager fragmentPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_details);

        initView();
        initViewPager();

        initIndicator();
    }

    public void initView() {

        viewPager = findViewById(R.id.tab_view_pager);
        magicIndicator = findViewById(R.id.magic_indicator);
        frameLayout = findViewById(R.id.fl_content_indicator);
    }

    /*
     * init indicator
     * */

    public void initIndicator() {

        for(int i=0; i< 5;i++) {

            list.add("标签 "+i);
        }

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {

                return 5;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {

                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(R.color.red_color);
                colorTransitionPagerTitleView.setSelectedColor(SupportMenu.CATEGORY_MASK);
                colorTransitionPagerTitleView.setText(list.get(index));
                //colorTransitionPagerTitleView.setOnClickListener(new BrandRankDetailActivityV1$1$1(this, i));
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {

                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);

                return indicator;
            }
        });

        magicIndicator.setNavigator(commonNavigator);
    }

    private void initViewPager() {

        this.fragmentList.add(initMainFg());

        fragmentPager =new FragmentPager(getSupportFragmentManager(),fragmentList);

        this.viewPager.setAdapter(fragmentPager);
    }

    // fg
    public MainFragment initMainFg() {

        mainFragment =new MainFragment();
        mainFragment.setTabBarListener(this);
        return mainFragment;
    }

    @Override
    public void ofChange(float f) {

        Log.e("ofChange123","---->  "+f);
        frameLayout.setAlpha(f);

        if(((double) f) > 0.3d) {

            frameLayout.setVisibility(View.VISIBLE);
        }else {
            frameLayout.setVisibility(View.INVISIBLE);
        }

        if (f >= 1.0f) {

            frameLayout.setAlpha(1.0f);
        } else if (f <= 0.0f) {

            frameLayout.setAlpha(0.0f);
        }

    }


    /*******************/

    class FragmentPager extends FragmentPagerAdapter {

        List<Fragment> fragments = new ArrayList();

        public FragmentPager(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }

        public void refreshAdpater(List<Fragment> list) {
            this.fragments = list;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {

            return  fragments.size();
        }

    }

}
