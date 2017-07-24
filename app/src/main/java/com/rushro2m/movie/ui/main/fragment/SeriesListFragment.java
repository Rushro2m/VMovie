package com.rushro2m.movie.ui.main.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.SeriesList;
import com.rushro2m.movie.ui.main.adapters.SeriesListAdapter;
import com.rushro2m.movie.ui.main.contract.SeriesListContract;
import com.rushro2m.movie.ui.main.model.SeriesListModel;
import com.rushro2m.movie.ui.main.presenter.SeriesListPresenter;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SeriesListFragment extends BaseFragment<SeriesListPresenter, SeriesListModel> implements SeriesListContract.View {
    public static final String TAG = SeriesListFragment.class.getName();
    @BindView(R.id.recycler_series_list)
    RecyclerView recycler_series_list;
    private SeriesListAdapter seriesListAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_series_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getSeriesList(1, 10);
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_series_list.setLayoutManager(manager);
        seriesListAdapter = new SeriesListAdapter(null, getActivity());
        recycler_series_list.setAdapter(seriesListAdapter);
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
    public void returnSeriesList(SeriesList seriesList) {
        seriesListAdapter.updataRes(seriesList.getData());
    }
}
