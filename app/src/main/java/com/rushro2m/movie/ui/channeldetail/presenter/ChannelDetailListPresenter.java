package com.rushro2m.movie.ui.channeldetail.presenter;

import com.rushro2m.movie.bean.ChannelDetailList;
import com.rushro2m.movie.ui.channeldetail.contract.ChannelDetailContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ChannelDetailListPresenter extends ChannelDetailContract.Presenter {

    @Override
    public void getChannelDetailList(int p, int size, int cateid) {
        mModel.getChannelDetailList(p, size, cateid)
                .subscribe(new Subscriber<ChannelDetailList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ChannelDetailList channelDetailList) {
                        mView.returnChannelDetaliList(channelDetailList);
                    }
                });
    }
}
