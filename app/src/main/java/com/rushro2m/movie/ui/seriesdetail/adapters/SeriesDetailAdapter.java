package com.rushro2m.movie.ui.seriesdetail.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rushro2m.movie.R;
import com.rushro2m.movie.bean.SeriesDetail;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeriesDetailAdapter extends RecyclerView.Adapter<SeriesDetailAdapter.ViewHolder>{

    private static final String TAG = SeriesDetailAdapter.class.getName();
    private SeriesDetail.SeriesDetailData mData;
    private Context mContext;
    private LayoutInflater inflater;

    private RecyclerView mRecyclerView;

    private int id;

    public SeriesDetailAdapter(SeriesDetail.SeriesDetailData mData, Context mContext,int id) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new SeriesDetail.SeriesDetailData();
        }
        this.mContext = mContext;
        this.id = id;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_activity_series_detail, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String duration = mData.getPosts().get(id).getList().get(position).getDuration();
        int d = Integer.parseInt(duration);
        int m = d / 60;
        int s = d % 60;
        if (m<10){
            holder.durtion.setText("0" + m + ":" + s);
        }else {
            holder.durtion.setText(m + ":" + s);
        }
        holder.time.setText(mData.getPosts().get(id).getList().get(position).getAddtime());
        holder.title.setText("第" + mData.getPosts().get(id).getList().get(position).getNumber()
                + "集：" + mData.getPosts().get(id).getList().get(position).getTitle());
        Picasso.with(mContext).load(mData.getPosts().get(id).getList().get(position).getThumbnail()).into(holder.image);
        Log.e(TAG, "图片地址是：: "+ mData.getPosts().get(id).getList().get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.getPosts().get(id).getList().size();
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

        @BindView(R.id.image_item_activity_series_detail)
        ImageView image;
        @BindView(R.id.durtion_item_activity_series_detail)
        TextView durtion;
        @BindView(R.id.title_item_activity_series_detail)
        TextView title;
        @BindView(R.id.time_item_activity_series_detail)
        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
