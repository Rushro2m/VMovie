package com.rushro2m.movie.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rock.mvplibrary.base.BaseFragment;
import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.ChannelList;
import com.rushro2m.movie.ui.main.adapters.ChannelListAdapter;
import com.rushro2m.movie.ui.main.contract.ChannelListContract;
import com.rushro2m.movie.ui.main.model.ChannelListModel;
import com.rushro2m.movie.ui.main.presenter.ChannelListPresenter;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ChannelListFragment extends BaseFragment<ChannelListPresenter, ChannelListModel> implements ChannelListContract.View {
    @BindView(R.id.recycler_channel_list)
    RecyclerView recycler_channel_list;
    private ChannelListAdapter channelListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_channel_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getChannelList();
    }

    @Override
    public void initView() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_channel_list.setLayoutManager(manager);
        channelListAdapter = new ChannelListAdapter(null, getActivity());
        recycler_channel_list.setAdapter(channelListAdapter);
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
    public void returnChannelList(ChannelList channelList) {
        channelListAdapter.updataRes(channelList.getData());
    }
}
