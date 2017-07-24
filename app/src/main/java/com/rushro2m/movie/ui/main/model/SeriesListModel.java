package com.rushro2m.movie.ui.main.model;

import com.rushro2m.movie.api.Api;
import com.rushro2m.movie.bean.SeriesList;
import com.rushro2m.movie.ui.main.contract.SeriesListContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SeriesListModel implements SeriesListContract.Model {
    @Override
    public Observable<SeriesList> getSeriesList(int p, int size) {
        return Api
                .getApiService()
                .getSeriesList(p, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
