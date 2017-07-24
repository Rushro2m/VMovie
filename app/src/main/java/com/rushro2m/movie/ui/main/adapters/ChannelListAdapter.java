package com.rushro2m.movie.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.ChannelList;
import com.rushro2m.movie.ui.channeldetail.activity.ChannelDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> implements View.OnClickListener {

    private List<ChannelList.ChannelData> mData;
    private Context mContext;
    private LayoutInflater inflater;

    private RecyclerView mRecyclerView;

    public ChannelListAdapter(List<ChannelList.ChannelData> mData, Context mContext) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updataRes(List<ChannelList.ChannelData> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_fragment_channel_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.type.setText("#" + mData.get(position).getCatename() + "#");
        Picasso.with(mContext).load(mData.get(position).getIcon()).into(holder.image);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        String cateid = mData.get(position).getCateid();
        String catename = mData.get(position).getCatename();
        Intent intent = new Intent(mContext, ChannelDetailActivity.class);
        intent.putExtra("cateid",cateid);
        intent.putExtra("catename",catename);
        mContext.startActivity(intent);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_main_channel_list)
        TextView type;

        @BindView(R.id.image_main_channel_list)
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
