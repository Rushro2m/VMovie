package com.rushro2m.movie.ui.main.contract;

import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;
import com.rushro2m.movie.bean.ChannelList;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface ChannelListContract {
    interface Model extends BaseModel {
        Observable<ChannelList> getChannelList();
    }

    interface View extends BaseView {
        void returnChannelList(ChannelList channelList);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getChannelList();
    }
}
