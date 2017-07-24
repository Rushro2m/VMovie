package com.rushro2m.movie.ui.main.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;
import com.rushro2m.movie.utils.SharedUtils;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements Animation.AnimationListener {
    @BindView(R.id.image_activity_splash_bg)
    ImageView image_bg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        ScaleAnimation sa = new ScaleAnimation(1, 1.05f, 1, 1.05f, 1, 1);
        sa.setFillAfter(true);
        sa.setDuration(2500);
        image_bg.startAnimation(sa);
        sa.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (SharedUtils.getFlags("isFirst")) {
            goActivity(MainActivity.class);
        }else {
            SharedUtils.putFlags("isFirst",true);
            goActivity(GuideActivity.class);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private void goActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
    }
}
