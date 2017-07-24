package com.rushro2m.movie.ui.seriesdetail.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.SeriesDetail;
import com.rushro2m.movie.ui.seriesdetail.adapters.SeriesDetailAdapter;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/24.
 */

public class SeriesDetailFragment extends BaseFragment {
    @BindView(R.id.recycler_series_detail)
    RecyclerView recyclerView;
    private SeriesDetailAdapter seriesDetailAdapter;

    private SeriesDetail.SeriesDetailData mData;
    int id;


    public SeriesDetailFragment(SeriesDetail.SeriesDetailData mData, int id) {
        this.mData = mData;
        this.id = id;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_series_detail;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        seriesDetailAdapter = new SeriesDetailAdapter(mData, getActivity(),id);
        recyclerView.setAdapter(seriesDetailAdapter);
    }
}
