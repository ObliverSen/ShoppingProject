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
 *
 * Created by zhoushaosen on 2019/3/20.
 *
 * 模拟数据
 */

public class HeadAdapter  extends RecyclerView.Adapter<HeadAdapter.HeadViewHolder> {

    private List<String> listHead;
    private Context context;

    private HeadAdapter(Context context,List<String> listHead) {

        this.context = context;
        this.listHead = listHead;
    }

    @Override
    public HeadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.title,null);
        return new HeadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeadViewHolder holder, int position) {

        TextView textView = holder.textView;
        textView.setText(listHead.get(0));
    }

    @Override
    public int getItemCount() {
        return listHead.size();
    }


    public static class HeadViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public HeadViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.title);
        }
    }
}
