package com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private int mSelectedPos = -1;

    private static RecyclerView recyclerViewTab;

    public TabAdapter(@NonNull Context context, List<TabTitlesData> list,RecyclerView recyclerViewTab) {

        this.context = context;
        this.list = list;
        this.recyclerViewTab = recyclerViewTab;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new TabViewHolder(inflater.inflate(R.layout.tab_recy_linear,
                      null,false));
    }

    @Override
    public void onBindViewHolder(TabViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getName());
        //
        if(list.get(position).isSelect()) {

            setItemSelected(context,holder.textView,true);
        }else {
            setItemSelected(context,holder.textView,false);
        }

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
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

    /**
     *  update
     * **/

    public  void textColorUpdate(int position) {

        if(mSelectedPos >= 0) {

            TabViewHolder holder = (TabViewHolder) recyclerViewTab.findViewHolderForLayoutPosition(mSelectedPos);

            if(holder != null) {
                setItemSelected(context,holder.textView,false);
            }else {

                notifyItemChanged(this.mSelectedPos);
            }
            list.get(mSelectedPos).setSelect(false);
        }

        this.mSelectedPos = position;
        TabViewHolder holder = (TabViewHolder) recyclerViewTab.findViewHolderForLayoutPosition(position);
        Log.e("holderss","---> "+holder+"   position:"+position);
        list.get(position).setSelect(true);
        if(holder != null) {

            setItemSelected(context,holder.textView,true);
        }else {

            notifyItemChanged(position);
        }

    }

    private  void setItemSelected(Context context,TextView textView, boolean z) {

        if (z) {

            textView.setTextColor(context.getResources().getColor(R.color.red));
        } else {

            textView.setTextColor(context.getResources().getColor(R.color.color_33));
        }
    }
}
