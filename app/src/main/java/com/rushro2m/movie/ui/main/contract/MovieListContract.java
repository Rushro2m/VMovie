package com.rushro2m.movie.ui.main.contract;

import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;
import com.rushro2m.movie.bean.MovieList;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface MovieListContract {

    interface Model extends BaseModel {
//        Observable<BannerList> getBannerList();

        Observable<MovieList> getMovieList(int page,int size);
    }

    interface View extends BaseView {
        void returnNewMovieList(MovieList movieList);

//        void returnMovieBanner(BannerList bannerList);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getNewMovieList(int page, int size);

//        public abstract void getBanner();
    }
}
