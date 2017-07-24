package com.rushro2m.movie.ui.main.model;

import com.rushro2m.movie.api.Api;
import com.rushro2m.movie.bean.MovieList;
import com.rushro2m.movie.ui.main.contract.MovieListContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MovieListModel implements MovieListContract.Model {

//    @Override
//    public Observable<BannerList> getBannerList() {
//        return Api
//                .getApiService()
//                .getBannerList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

    @Override
    public Observable<MovieList> getMovieList(int page, int size) {
        return Api
                .getApiService()
                .getMovieList(page, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
