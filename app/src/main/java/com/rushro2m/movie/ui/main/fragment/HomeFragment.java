package com.rushro2m.movie.ui.main.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.ui.main.activity.MainActivity;
import com.rushro2m.movie.ui.main.adapters.HomePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    public static final String TAG = HomeFragment.class.getName();

    @BindView(R.id.main_home_viewpager)
    ViewPager vp_home;
    private MainActivity mainActivity;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {
        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager(), getFragments());
        vp_home.setAdapter(adapter);
        vp_home.addOnPageChangeListener(this);
    }

    public List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MovieListFragment());
        fragments.add(new ChannelListFragment());
        return fragments;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mainActivity != null) {
            mainActivity.viewPagerOffset(position + positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
