package com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.ShoppingContentBean;
import com.shopping.R;
import com.utils.LoadImage;
import com.utils.ScreenUtil;

import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/24.
 *
 */

public class ShappingContentAdapter extends RecyclerView.Adapter<ShappingContentAdapter.ShappingContentHolder> {

    private final int ivImgWidth;
    private Context context;
    private ShoppingContentBean bean;
    private LayoutInflater inflater;

    public ShappingContentAdapter(@NonNull  Context context, ShoppingContentBean bean) {
        this.context = context;
        this.bean = bean;
        inflater = LayoutInflater.from(context);

        // 计算每张图片宽度所占的数值
        ivImgWidth = (ScreenUtil.getScreenWidth(context)
                - ScreenUtil.dp2px(context, 28.0f)) / 3;
    }

    @Override
    public ShappingContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ShappingContentHolder(inflater.inflate(R.layout.item_shopping_content,parent,
                    false));
    }

    @Override
    public void onBindViewHolder(ShappingContentHolder holder, int position) {


        if(holder != null) {

            measusreImgWidth(holder);
        }
        holder.textView.setText(bean.getData().get(position).getContent());


        LoadImage.loadImage(context,bean.getData().get(position).getPic(),
                holder.imageView1,R.mipmap.ic_launcher_round);

        LoadImage.loadImage(context,bean.getData().get(position).getPic2(),
                holder.imageView2,R.mipmap.ic_launcher_round);

    }

    @Override
    public int getItemCount() {

        return bean.getData().size();
    }

    public static class ShappingContentHolder extends RecyclerView.ViewHolder{


        TextView textView;
        ImageView imageView1;
        ImageView imageView2;

        public ShappingContentHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.mian_item);
            imageView1 = itemView.findViewById(R.id.img1);
            imageView2 = itemView.findViewById(R.id.img2);
        }
    }

    private void measusreImgWidth(ShappingContentHolder holder) {

        if(this.ivImgWidth != 0 && holder != null) {

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.imageView1.getLayoutParams();
            layoutParams.width = this.ivImgWidth;
            layoutParams.height = this.ivImgWidth;

            holder.imageView1.setLayoutParams(layoutParams);
            holder.imageView2.setLayoutParams(layoutParams);
        }
    }

}
