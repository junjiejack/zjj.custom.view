package com.kevin.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kevin.app.R;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.module.custom.CustomViewFragment;
import com.kevin.app.module.home.HomeFragment;
import com.kevin.app.module.other.OtherFragment;
import com.kevin.app.module.third.ThirdFragment;
import com.kevin.app.view.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpBaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.view_pager)
    NoScrollViewPager viewPager;
    @BindView(R.id.rb_group)
    RadioGroup radioGroup;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_view)
    RadioButton rbView;
    @BindView(R.id.rb_third)
    RadioButton rbThird;
    @BindView(R.id.rb_other)
    RadioButton rbOther;

    private ArrayList<Fragment> fragments;
    private FragmentPagerAdapter pagerAdapter;

    @Override
    protected MvpBasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        initFragmentList();
        initFragment();
        initListener();
    }

    private void initFragmentList() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CustomViewFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new OtherFragment());
    }

    private void initFragment() {
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(pagerAdapter);
    }

    private void initListener() {
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.rb_view:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.rb_third:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.rb_other:
                viewPager.setCurrentItem(3,false);
                break;
        }
    }

}
