package com.rushro2m.movie.ui.main.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;
import com.rushro2m.movie.ui.login.activity.LoginActivity;
import com.rushro2m.movie.ui.main.fragment.BehindListFragment;
import com.rushro2m.movie.ui.main.fragment.HomeFragment;
import com.rushro2m.movie.ui.main.fragment.SeriesListFragment;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private boolean isExit;
    @BindView(R.id.main_cover)
    View coverLayout;

    @BindView(R.id.main_cover_close)
    ImageView closeMenu;

    @BindView(R.id.main_cover_home)
    RadioButton homeRadio;

    @BindView(R.id.main_cover_series)
    RadioButton seriesRadio;

    @BindView(R.id.main_cover_behind)
    RadioButton behindRadio;

    @BindView(R.id.main_title)
    TextView mainTitle;

    @BindView(R.id.main_home_title)
    View mainHomeTitle;

    @BindView(R.id.main_first_page_channel)
    TextView channel;

    @BindView(R.id.main_first_page_indicator)
    View indicator;

    private Fragment mShowFragment;

    @BindView(R.id.main_first_page_new)
    TextSwitcher mSwitcher;

    private int channelLeft;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        switchPage(HomeFragment.TAG);

    }

    //打开左侧的菜单
    @OnClick(R.id.main_home)
    void openMenu() {
        showCover();
    }

    //关闭菜单
    @OnClick(R.id.main_cover_close)
    void closeMenu() {
        closeCover();
    }


    //点击RadioButton后，隐藏左侧菜单
    @OnClick(value = {R.id.main_cover_home, R.id.main_cover_behind, R.id.main_cover_series})
    void onRadioClick() {
        hideCover();
    }

    @OnCheckedChanged(value = {R.id.main_cover_home, R.id.main_cover_series, R.id.main_cover_behind})
    void onCheckedChanged(CompoundButton view, boolean isChecked) {
        if (isChecked) {
            switch (view.getId()) {
                case R.id.main_cover_home:
                    switchPage(HomeFragment.TAG);
                    mainHomeTitle.setVisibility(View.VISIBLE);
                    break;
                case R.id.main_cover_series:
                    switchPage(SeriesListFragment.TAG);
                    mainHomeTitle.setVisibility(View.GONE);
                    mainTitle.setText("系列");
                    break;
                case R.id.main_cover_behind:
                    switchPage(BehindListFragment.TAG);
                    mainHomeTitle.setVisibility(View.GONE);
                    mainTitle.setText("幕后");
                    break;
            }
        }
    }

    //打开左侧菜单
    private void showCover() {

        //将布局设为可见
        coverLayout.setVisibility(View.VISIBLE);

        //三个RadioButton初始设为完全透明
        homeRadio.setAlpha(0);
        seriesRadio.setAlpha(0);
        behindRadio.setAlpha(0);

        //三个Button的动画效果
        ObjectAnimator home = ObjectAnimator.ofFloat(homeRadio, "alpha", 0, 1);
        home.setDuration(200);
        ObjectAnimator series = ObjectAnimator.ofFloat(seriesRadio, "alpha", 0, 1);
        series.setDuration(200);
        ObjectAnimator behind = ObjectAnimator.ofFloat(behindRadio, "alpha", 0, 1);
        behind.setDuration(200);

        //一次播放三个控件的动画
        AnimatorSet set = new AnimatorSet();
        set.play(home);
        set.play(series).after(200);
        set.play(behind).after(400);
        set.start();

        //关闭按钮的动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(closeMenu, "scaleX", 0, 1.2f, 1);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(closeMenu, "scaleY", 0, 1.2f, 1);
        AnimatorSet closeMenuAnima = new AnimatorSet();
        closeMenuAnima.setDuration(500);
        closeMenuAnima.play(scaleX).with(scaleY);
        closeMenuAnima.start();
    }

    //关闭左侧菜单
    private void closeCover() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(closeMenu, "scaleX", 1, 1.2f, 0);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(closeMenu, "scaleY", 1, 1.2f, 0);
        AnimatorSet set = new AnimatorSet();
        set.play(scaleX).with(scaleY);
        set.setDuration(500);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                coverLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    //隐藏左侧菜单
    private void hideCover() {
        if (coverLayout.getVisibility() == View.VISIBLE) {
            coverLayout.setVisibility(View.GONE);
        }
    }

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (coverLayout.getVisibility() == View.VISIBLE) {
                coverLayout.setVisibility(View.GONE);
                return true;
            }
            if (!isExit) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                isExit = true;
                //还原标志位状态
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2 * 1000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void switchPage(String fragmentTag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (mShowFragment != null) {
            ft.hide(mShowFragment);
        }
        mShowFragment = fm.findFragmentByTag(fragmentTag);
        if (mShowFragment != null) {
            ft.show(mShowFragment);
        } else {
            try {
                mShowFragment = (Fragment) Class.forName(fragmentTag).newInstance();
                ft.add(R.id.main_container, mShowFragment, fragmentTag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ft.commit();
    }

    public void viewPagerOffset(float f) {
        if (channelLeft == 0) {
            channelLeft = channel.getLeft();
            indicator.setTranslationX(f * channelLeft);
        }
    }

    @OnClick(value = {R.id.main_first_page_new,
            R.id.main_first_page_channel})
    void onIndicatorChanged(View view) {
        switch (view.getId()) {
//            case R.id.
        }
    }

    //跳转到登录界面
    @OnClick(value = {R.id.main_cover_icon,
            R.id.main_cover_name,
            R.id.main_cover_subscribe,
            R.id.main_cover_cache,
            R.id.main_cover_likes})
    void onLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
