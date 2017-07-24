package com.rushro2m.movie.ui.main.model;

import com.rushro2m.movie.api.Api;
import com.rushro2m.movie.bean.BehindTabList;
import com.rushro2m.movie.ui.main.contract.BehindTabListContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class BehindTabListModel implements BehindTabListContract.Model {

    @Override
    public Observable<BehindTabList> getBehindTabList() {
        return Api
                .getApiService()
                .getBehindTabList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
