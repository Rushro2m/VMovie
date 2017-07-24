package com.rushro2m.movie.ui.main.presenter;

import com.rushro2m.movie.bean.ChannelList;
import com.rushro2m.movie.ui.main.contract.ChannelListContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ChannelListPresenter extends ChannelListContract.Presenter {

    @Override
    public void getChannelList() {
        mModel.getChannelList().subscribe(new Subscriber<ChannelList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ChannelList channelList) {
                mView.returnChannelList(channelList);
            }
        });
    }
}
