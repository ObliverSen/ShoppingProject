package com.adapter;

import android.content.Context;
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

public class AllTabAdapter extends RecyclerView.Adapter<AllTabAdapter.AllTabViewHolder> {

    private Context context;
    private List<TabTitlesData>  list;
    private LayoutInflater inflater;

    private CallBackPosition callBackPosition;

    public AllTabAdapter(@NonNull Context context, List<TabTitlesData> list,
                         CallBackPosition callBackPosition) {

        this.context = context;
        this.list = list;
        this.callBackPosition = callBackPosition;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public AllTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new AllTabViewHolder(inflater.inflate(R.layout.tab_recy_linear,
                      null,false));
    }

    @Override
    public void onBindViewHolder(AllTabViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  callBackPosition.selectPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AllTabViewHolder  extends RecyclerView.ViewHolder{

        private TextView textView;
        public AllTabViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tab_txt);
        }
    }

    public interface CallBackPosition{

        void selectPosition(int position);
    }
}
