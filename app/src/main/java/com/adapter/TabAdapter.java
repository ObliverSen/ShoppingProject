package com.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bean.TabTitlesData;
import com.shopping.R;

import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/24.
 *
 */

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {

    private Context context;
    private List<TabTitlesData>  list;
    private LayoutInflater inflater;


    public TabAdapter(@NonNull Context context, List<TabTitlesData> list) {

        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new TabViewHolder(inflater.inflate(R.layout.tab_recy_linear,
                      null,false));
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TabViewHolder  extends RecyclerView.ViewHolder{

        private TextView textView;
        public TabViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tab_txt);
        }
    }
}
