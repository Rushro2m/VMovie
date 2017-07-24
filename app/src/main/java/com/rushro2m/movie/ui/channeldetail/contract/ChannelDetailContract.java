package com.rushro2m.movie.ui.channeldetail.contract;

import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;
import com.rushro2m.movie.bean.ChannelDetailList;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface ChannelDetailContract {
    interface Model extends BaseModel {
        Observable<ChannelDetailList> getChannelDetailList(int p,int size,int cateid);
    }

    interface View extends BaseView {
        void returnChannelDetaliList(ChannelDetailList channelDetailList);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getChannelDetailList(int p,int size,int cateid);
    }
}
