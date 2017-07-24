package com.rushro2m.movie.ui.login.activity;

import android.widget.ImageView;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_back)
    ImageView back;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.login_back)
    void onBack(){
        finish();
    }
}
