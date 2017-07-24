package com.rushro2m.movie.ui.seriesdetail.contract;

import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;
import com.rushro2m.movie.bean.SeriesDetail;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface SeriesDetailContract {

    interface Model extends BaseModel {
        Observable<SeriesDetail> getSeriesDetail(String seriesid);
    }

    interface View extends BaseView {
        void returnSeriesDetail(SeriesDetail seriesDetail);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getSeriesDetail(String seriesid);

    }
}
