package com.rushro2m.movie.ui.seriesdetail.model;

import com.rushro2m.movie.api.Api;
import com.rushro2m.movie.bean.SeriesDetail;
import com.rushro2m.movie.ui.seriesdetail.contract.SeriesDetailContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class SeriesDetailModel implements SeriesDetailContract.Model {

    @Override
    public Observable<SeriesDetail> getSeriesDetail(String seriesid) {
        return Api
                .getApiService()
                .getSeriesDetail(seriesid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
