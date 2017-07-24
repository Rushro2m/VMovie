package com.rushro2m.movie.ui.main.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.BehindTabList;
import com.rushro2m.movie.ui.main.adapters.BehindPagerAdapter;
import com.rushro2m.movie.ui.main.contract.BehindTabListContract;
import com.rushro2m.movie.ui.main.model.BehindTabListModel;
import com.rushro2m.movie.ui.main.presenter.BehindTabListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BehindListFragment extends BaseFragment<BehindTabListPresenter, BehindTabListModel> implements BehindTabListContract.View {

    public static final String TAG = BehindListFragment.class.getName();

    @BindView(R.id.vp_main_behind)
    ViewPager vp;
    @BindView(R.id.tab_main_behind)
    TabLayout tab;
    BehindPagerAdapter behindPagerAdapter;
    List<String> titles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    String catename;
    BehindFragment bf;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_behind_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getBehindTabList();
    }

    @Override
    public void initView() {

    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnBehindTabList(BehindTabList behindTabList) {
        Bundle bundle = new Bundle();

        for (int i = 0; i < behindTabList.getData().size(); i++) {
            catename = behindTabList.getData().get(i).getCatename();
            titles.add(catename);
            bundle.putString("msg", catename);
            bf = new BehindFragment();
            bf.setArguments(bundle);
            fragments.add(bf);
        }
        Log.e(TAG, "returnBehindTabList: " + titles.size());
        behindPagerAdapter = new BehindPagerAdapter(getChildFragmentManager(), fragments, titles);
        vp.setAdapter(behindPagerAdapter);
        tab.setupWithViewPager(vp);
    }
}
