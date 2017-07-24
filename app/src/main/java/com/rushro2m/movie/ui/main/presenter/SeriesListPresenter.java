package com.rushro2m.movie.ui.main.presenter;

import com.rushro2m.movie.bean.SeriesList;
import com.rushro2m.movie.ui.main.contract.SeriesListContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SeriesListPresenter extends SeriesListContract.Presenter {
    @Override
    public void getSeriesList(int p, int size) {
        mModel.getSeriesList(p, size).subscribe(new Subscriber<SeriesList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SeriesList seriesList) {
                mView.returnSeriesList(seriesList);
            }
        });
    }
}
