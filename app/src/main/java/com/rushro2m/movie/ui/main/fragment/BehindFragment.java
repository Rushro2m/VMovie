package com.rushro2m.movie.ui.main.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/23.
 */

public class BehindFragment extends BaseFragment {
    @BindView(R.id.msg_fragment_behind)
    TextView tv;
    String msg;

    public BehindFragment() {
        Bundle bundle = getArguments();
        msg = bundle.getString("msg");
        tv.setText(msg);
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_behind;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void initView() {

    }
}
