package com.akmal5labs.tabpoc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by azlan on 28/03/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private List<String> mListOne;

    public Adapter(List<String> mListOne) {
//        this.mContext = mContext;
        this.mListOne = mListOne;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View  v = inflater.inflate(R.layout.row, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String a = mListOne.get(position);

        holder.tvText.setText(a);
    }

    @Override
    public int getItemCount() {
        return mListOne.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text)
        TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
