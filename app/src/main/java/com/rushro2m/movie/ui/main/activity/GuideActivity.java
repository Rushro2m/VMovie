package com.rushro2m.movie.ui.main.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;
import com.rushro2m.movie.ui.main.adapters.GuidePagerAdapter;
import com.rushro2m.movie.ui.main.fragment.GuideOneFragment;
import com.rushro2m.movie.ui.main.fragment.GuideThreeFragment;
import com.rushro2m.movie.ui.main.fragment.GuideTwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GuideActivity extends BaseActivity {
    @BindView(R.id.vp_activity_guide)
    ViewPager vp;


    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        GuidePagerAdapter guidePagerAdapter = new GuidePagerAdapter(getSupportFragmentManager(), getFragments());
        vp.setAdapter(guidePagerAdapter);
    }

    public List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new GuideOneFragment());
        fragments.add(new GuideTwoFragment());
        fragments.add(new GuideThreeFragment());
        return fragments;
    }




}
