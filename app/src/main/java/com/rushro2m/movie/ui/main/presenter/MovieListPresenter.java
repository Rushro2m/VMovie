package com.rushro2m.movie.ui.main.presenter;

import com.rushro2m.movie.bean.MovieList;
import com.rushro2m.movie.ui.main.contract.MovieListContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MovieListPresenter extends MovieListContract.Presenter {
    @Override
    public void getNewMovieList(int page, int size) {
        mModel.getMovieList(page, size).subscribe(new Subscriber<MovieList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieList movieList) {
                mView.returnNewMovieList(movieList);
            }
        });
    }
//
//    @Override
//    public void getBanner() {
//        mModel.getBannerList().subscribe(new Subscriber<BannerList>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(BannerList bannerList) {
//                mView.returnMovieBanner(bannerList);
//            }
//        });
//    }
}
