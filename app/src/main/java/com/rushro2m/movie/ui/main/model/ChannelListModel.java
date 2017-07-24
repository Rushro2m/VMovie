package com.rushro2m.movie.ui.main.model;

import com.rushro2m.movie.api.Api;
import com.rushro2m.movie.bean.ChannelList;
import com.rushro2m.movie.ui.main.contract.ChannelListContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ChannelListModel implements ChannelListContract.Model {

    @Override
    public Observable<ChannelList> getChannelList() {
        return Api
                .getApiService()
                .getChannelList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
