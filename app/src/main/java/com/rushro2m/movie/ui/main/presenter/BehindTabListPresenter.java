package com.rushro2m.movie.ui.main.presenter;

import android.util.Log;

import com.rushro2m.movie.bean.BehindTabList;
import com.rushro2m.movie.ui.main.contract.BehindTabListContract;

import rx.Subscriber;


public class BehindTabListPresenter extends BehindTabListContract.Presenter {
    private  static final String TAG = BehindTabListPresenter.class.getName();

    @Override
    public void getBehindTabList() {
        mModel.getBehindTabList().subscribe(new Subscriber<BehindTabList>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: 加载成功");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: 加载错误");
            }

            @Override
            public void onNext(BehindTabList behindTabList) {
                mView.returnBehindTabList(behindTabList);
            }
        });
    }
}
