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
import com.rushro2m.movie.bean.MovieList;
import com.rushro2m.movie.ui.moviedetail.activity.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/21.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> implements View.OnClickListener {

    private List<MovieList.MovieData> mData;
    private Context mContext;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;

    private boolean loadMore;

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public boolean isLoadMore() {
        return loadMore;
    }

    public MovieListAdapter(List<MovieList.MovieData> mData, Context mContext) {
        if (mData != null) {
            this.mData = mData;
        } else {
            this.mData = new ArrayList<>();
        }
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    public void updataRes(List<MovieList.MovieData> mData) {
        if (mData != null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    public void loadMore(List<MovieList.MovieData> mData){
        if (mData!=null) {
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_fragment_movie_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getTitle());
        String type = mData.get(position).getCates().get(0).getCatename();

        int time = Integer.parseInt(mData.get(position).getDuration());
        String m = null;
        String s = null;
        if (time > 60) {
            m = time / 60 + "";
            s = time % 60 + "";
        }
        holder.time.setText(type + "/" + m + "分" + s + "秒");
        Picasso.with(mContext).load(mData.get(position).getImage()).into(holder.image);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
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

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        String postid = mData.get(position).getPostid();
        Intent intent = new Intent(mContext, MovieDetailActivity.class);
        intent.putExtra("postid",postid);
        mContext.startActivity(intent);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_main_movie_list)
        TextView title;
        @BindView(R.id.time_main_movie_list)
        TextView time;
        @BindView(R.id.image_main_movie_list)
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
