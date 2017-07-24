package com.rushro2m.movie.ui.channeldetail.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rock.mvplibrary.base.BaseActivity;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.ChannelDetailList;
import com.rushro2m.movie.ui.channeldetail.adapters.ChannelDetailListAdapter;
import com.rushro2m.movie.ui.channeldetail.contract.ChannelDetailContract;
import com.rushro2m.movie.ui.channeldetail.model.ChannelDetailListModel;
import com.rushro2m.movie.ui.channeldetail.presenter.ChannelDetailListPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class ChannelDetailActivity extends BaseActivity<ChannelDetailListPresenter, ChannelDetailListModel> implements ChannelDetailContract.View {

    @BindView(R.id.recycler_channel_detail)
    RecyclerView recycler_channel_detail;

    @BindView(R.id.channel_detail_back)
    ImageView back;

    @BindView(R.id.channel_detail_type)
    TextView type;
    private ChannelDetailListAdapter channelDetailListAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_channel_detail;

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
        Intent intent = getIntent();
        String cateid = intent.getStringExtra("cateid");
        String catename = intent.getStringExtra("catename");
        mPresenter.getChannelDetailList(1,10, Integer.parseInt(cateid));
        type.setText(catename);
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_channel_detail.setLayoutManager(manager);
        channelDetailListAdapter = new ChannelDetailListAdapter(null,this);
        recycler_channel_detail.setAdapter(channelDetailListAdapter);
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
    public void returnChannelDetaliList(ChannelDetailList channelDetailList) {
        channelDetailListAdapter.updataRes(channelDetailList.getData());
    }

    @OnClick(R.id.channel_detail_back)
    void back(){
        finish();
    }
}
