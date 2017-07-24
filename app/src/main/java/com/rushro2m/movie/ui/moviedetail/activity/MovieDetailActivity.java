package com.rushro2m.movie.ui.moviedetail.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;
import com.rushro2m.movie.api.ApiService;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MovieDetailActivity extends BaseActivity {
    @BindView(R.id.webView_activity_movie_detail)
    WebView webView;
    @BindView(R.id.jc_activity_movie_detail_header)
    JCVideoPlayerStandard jc;

    @Override
    public int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String postid = getIntent().getStringExtra("postid");
        webView.loadUrl(String.format(ApiService.WEB_URL, postid));
        jc.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
//        jc.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        jc.thumbImageView.setImageResource(R.mipmap.ic_launcher);
        jc.tinyBackImageView.setImageResource(R.mipmap.back_icon);

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
