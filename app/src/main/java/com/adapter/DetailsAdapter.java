package com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shopping.R;

import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/29.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsContentViewHolder>{

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public DetailsAdapter(Context context, List<String> list) {

        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public DetailsContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new DetailsContentViewHolder(inflater.inflate(R.layout.item_details,parent,
                     false));
    }

    @Override
    public void onBindViewHolder(DetailsContentViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class DetailsContentViewHolder extends RecyclerView.ViewHolder {


        public DetailsContentViewHolder(View itemView) {
            super(itemView);
        }
    }

}
