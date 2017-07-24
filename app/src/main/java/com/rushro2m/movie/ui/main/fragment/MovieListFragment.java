package com.rushro2m.movie.ui.main.fragment;

import android.support.v7.widget.RecyclerView;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.MovieList;
import com.rushro2m.movie.ui.main.adapters.MovieListAdapter;
import com.rushro2m.movie.ui.main.contract.MovieListContract;
import com.rushro2m.movie.ui.main.model.MovieListModel;
import com.rushro2m.movie.ui.main.presenter.MovieListPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MovieListFragment extends BaseFragment<MovieListPresenter, MovieListModel> implements MovieListContract.View, OnRefreshListener, OnLoadmoreListener {

    @BindView(R.id.recycler_movie_list)
    RecyclerView recycler_movie_list;
    List<String> images;
    private MovieListAdapter movieListAdapter;

    @BindView(R.id.refresh_fragment_movie_list)
    RefreshLayout refreshLayout;
    public int page = 1;
    public int size = 10;
    private List<MovieList.MovieData> mData;
    private List<MovieList.MovieData> allData;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getNewMovieList(page, size);
    }

    @Override
    public void initView() {
        images = new ArrayList<>();
        allData = new ArrayList<>();
        movieListAdapter = new MovieListAdapter(null, getActivity());
        recycler_movie_list.setAdapter(movieListAdapter);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadmoreListener(this);
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
    public void returnNewMovieList(MovieList movieList) {
        mData = movieList.getData();
        if (movieListAdapter.isLoadMore()) {
            movieListAdapter.setLoadMore(false);
            movieListAdapter.updataRes(movieList.getData());
        } else {
//            allData.addAll(mData);
//            movieListAdapter.loadMore(allData);
            movieListAdapter.loadMore(mData);
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 1;
        mPresenter.getNewMovieList(page, size);
        movieListAdapter.updataRes(mData);
        refreshlayout.finishRefresh(2 * 1000);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        movieListAdapter.setLoadMore(true);
        mPresenter.getNewMovieList(++page, size);
//        movieListAdapter.loadMore(mData);
        refreshLayout.finishLoadmore(2000);
    }
}
