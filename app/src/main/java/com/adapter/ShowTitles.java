package com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shopping.R;

import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/21.
 */

public class ShowTitles extends RecyclerView.Adapter<ShowTitles.TitlesViewHolder>{

    private Context context;

    private List<String> list;

    private LayoutInflater layoutInflater;

    public ShowTitles(Context context,List<String> list) {

        this.context = context;
        this.list = list;

        layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public TitlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new TitlesViewHolder(layoutInflater.inflate(R.layout.title,parent,false));
    }

    @Override
    public void onBindViewHolder(TitlesViewHolder holder, int position) {

        holder.textView.setText(this.list.get(position));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class TitlesViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public TitlesViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.title);
        }
    }

}
