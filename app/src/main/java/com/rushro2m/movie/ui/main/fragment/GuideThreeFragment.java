package com.rushro2m.movie.ui.main.fragment;

import android.content.Intent;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.ui.main.activity.MainActivity;

import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/24.
 */

public class GuideThreeFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_guide_three;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.goActivity)
    void nextActivity() {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }

}
