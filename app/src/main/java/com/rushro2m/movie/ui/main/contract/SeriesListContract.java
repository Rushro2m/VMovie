package com.rushro2m.movie.ui.main.contract;

import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;
import com.rushro2m.movie.bean.SeriesList;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface SeriesListContract {
    interface Model extends BaseModel {
        Observable<SeriesList> getSeriesList(int p, int size);
    }

    interface View extends BaseView {
        void returnSeriesList(SeriesList seriesList);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getSeriesList(int p, int size);
    }
}
