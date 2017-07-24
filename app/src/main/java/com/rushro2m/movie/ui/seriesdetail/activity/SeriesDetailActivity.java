package com.rushro2m.movie.ui.seriesdetail.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.SeriesDetail;
import com.rushro2m.movie.ui.seriesdetail.adapters.SeriesDetailPagerAdapter;
import com.rushro2m.movie.ui.seriesdetail.contract.SeriesDetailContract;
import com.rushro2m.movie.ui.seriesdetail.fragments.SeriesDetailFragment;
import com.rushro2m.movie.ui.seriesdetail.model.SeriesDetailModel;
import com.rushro2m.movie.ui.seriesdetail.presenter.SeriesDetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class SeriesDetailActivity extends BaseActivity<SeriesDetailPresenter, SeriesDetailModel> implements SeriesDetailContract.View {
    @BindView(R.id.movietitle_activity_series_detail)
    TextView movietitle;
    @BindView(R.id.title_activity_series_detail)
    TextView title;
    @BindView(R.id.weekly_activity_series_detail)
    TextView weekly;
    @BindView(R.id.update_activity_series_detail)
    TextView update;
    @BindView(R.id.tag_activity_series_detail)
    TextView tag;
    @BindView(R.id.content_activity_series_detail)
    TextView content;
    @BindView(R.id.all_activity_series_detail)
    TextView all;

    boolean isShowAll = false;

    @BindView(R.id.jc_activity_series_detail)
    JCVideoPlayerStandard jc;

    @BindView(R.id.dy_activity_series_detail)
    TextView dy;

    @BindView(R.id.tab_activity_series_detail)
    TabLayout tab;

    @BindView(R.id.vp_activity_series_detail)
    ViewPager vp;

    Fragment fragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_series_detail;
    }

    @Override
    public void initPresenter() {
        Intent intent = getIntent();
        String seriesid = intent.getStringExtra("seriesid");
        mPresenter.setVM(this, mModel);
        mPresenter.getSeriesDetail(seriesid);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnSeriesDetail(SeriesDetail seriesDetail) {
        SeriesDetail.SeriesDetailData data = seriesDetail.getData();
        movietitle.setText(data.getPosts().get(0).getList().get(0).getTitle());
        title.setText(data.getTitle());
        weekly.setText("更新：" + data.getWeekly());
        update.setText("集数：" + data.getUpdate_to());
        tag.setText("类型：" + data.getTag_name());
        content.setText(data.getContent());
        dy.setText("已有" + data.getCount_follow() + "人订阅");
        jc.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "试播视频");
//        jc.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        jc.thumbImageView.setImageResource(R.mipmap.ic_launcher);
        List<String> titles = new ArrayList<>();
        int size = data.getPosts().size();

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            fragment = new SeriesDetailFragment(data,i);
            fragments.add(fragment);
            titles.add(data.getPosts().get(i).getFrom_to());
        }
        SeriesDetailPagerAdapter seriesDetailPagerAdapter = new SeriesDetailPagerAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(seriesDetailPagerAdapter);
        tab.setupWithViewPager(vp);
    }

    @OnClick(R.id.all_activity_series_detail)
    void showAll() {
        isShowAll = !isShowAll;
        if (isShowAll) {
            all.setText("收起简介");
            content.setMaxLines(10);
        } else {
            all.setText("查看全部");
            content.setMaxLines(2);
        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
