package com.rushro2m.movie.ui.channeldetail.model;

import com.rushro2m.movie.api.Api;
import com.rushro2m.movie.bean.ChannelDetailList;
import com.rushro2m.movie.ui.channeldetail.contract.ChannelDetailContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ChannelDetailListModel implements ChannelDetailContract.Model {

    @Override
    public Observable<ChannelDetailList> getChannelDetailList(int p, int size, int cateid) {
        return Api
                .getApiService()
                .getChannelDetailList(p,size,cateid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
