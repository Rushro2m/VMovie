package com.rushro2m.movie.api;

import com.rushro2m.movie.bean.BannerList;
import com.rushro2m.movie.bean.BehindList;
import com.rushro2m.movie.bean.BehindTabList;
import com.rushro2m.movie.bean.ChannelDetailList;
import com.rushro2m.movie.bean.ChannelList;
import com.rushro2m.movie.bean.MovieList;
import com.rushro2m.movie.bean.SeriesDetail;
import com.rushro2m.movie.bean.SeriesList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiService {
    //广告轮播
    @GET("/apiv3/index/getBanner")
    Observable<BannerList> getBannerList();

    //首页最新电影列表
    ///apiv3/post/getPostByTab
    @GET("/apiv3/post/getPostByTab")
    Observable<MovieList> getMovieList(@Query("p") int p, @Query("size") int size);

    //首页的频道列表
    @GET("/apiv3/cate/getList")
    Observable<ChannelList> getChannelList();

    //获取系列
    @GET("/apiv3/series/getList")
    Observable<SeriesList> getSeriesList(@Query("p") int p, @Query("size") int size);

    //幕后顶部导航
    @GET("/apiv3/backstage/getCate")
    Observable<BehindTabList> getBehindTabList();

    //幕后内容区
    @GET("/apiv3/backstage/getPostByCate")
    Observable<BehindList> getBehindList(@Query("p") int p, @Query("size") int size, @Query("cateid") int cateid);

    //频道详情
    @GET("/apiv3/post/getPostInCate")
    Observable<ChannelDetailList> getChannelDetailList(@Query("p") int p, @Query("size") int size, @Query("cateid") int cateid);

    @GET("/apiv3/series/view")
    Observable<SeriesDetail> getSeriesDetail(@Query("seriesid") String seriesid);

    //要显示的电影详情界面
    String WEB_URL = "http://app.vmoiver.com/%s?qingapp=app_new";
}
