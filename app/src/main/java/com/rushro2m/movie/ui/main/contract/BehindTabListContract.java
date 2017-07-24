package com.rushro2m.movie.ui.main.contract;

import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;
import com.rushro2m.movie.bean.BehindTabList;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface BehindTabListContract {
    interface Model extends BaseModel {
        Observable<BehindTabList> getBehindTabList();
    }

    interface View extends BaseView {
        void returnBehindTabList(BehindTabList behindTabList);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getBehindTabList();
    }
}
