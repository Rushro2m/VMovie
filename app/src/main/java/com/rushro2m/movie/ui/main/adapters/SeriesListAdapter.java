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
import com.rushro2m.movie.bean.SeriesList;
import com.rushro2m.movie.ui.seriesdetail.activity.SeriesDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/21.
 */

public class SeriesListAdapter extends RecyclerView.Adapter<SeriesListAdapter.ViewHolder> implements View.OnClickListener {

    private List<SeriesList.SeriesData> mData;
    private Context mContext;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;

    public SeriesListAdapter(List<SeriesList.SeriesData> mData, Context mContext) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updataRes(List<SeriesList.SeriesData> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_fragment_series_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getTitle());
        String updataNums = mData.get(position).getUpdate_to();
        String follower = mData.get(position).getFollower_num();
        String content = mData.get(position).getContent();
        holder.num.setText("已更新至" + updataNums + "集" + "  " + follower + "人已订阅");
        holder.msg.setText(content);
        Picasso.with(mContext).load(mData.get(position).getImage()).into(holder.image);

        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        String seriesid = mData.get(position).getSeriesid();
        Intent intent = new Intent(mContext, SeriesDetailActivity.class);
        intent.putExtra("seriesid",seriesid);
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


        @BindView(R.id.image_main_series_list)
        ImageView image;

        @BindView(R.id.title_main_series_list)
        TextView title;

        @BindView(R.id.num_main_series_list)
        TextView num;

        @BindView(R.id.msg_main_series_list)
        TextView msg;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
