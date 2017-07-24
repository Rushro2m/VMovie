package com.rushro2m.movie.ui.seriesdetail.presenter;

import com.rushro2m.movie.bean.SeriesDetail;
import com.rushro2m.movie.ui.seriesdetail.contract.SeriesDetailContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SeriesDetailPresenter extends SeriesDetailContract.Presenter {

    @Override
    public void getSeriesDetail(String seriesid) {
        mModel.getSeriesDetail(seriesid).subscribe(new Subscriber<SeriesDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SeriesDetail seriesDetail) {
                mView.returnSeriesDetail(seriesDetail);
            }
        });
    }
}
