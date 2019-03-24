package com.widget;


import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.adapter.TabAdapter;
import com.bean.TabTitlesData;
import com.shopping.R;

import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/24.
 *
 */

public class BouncingTabMenu implements BouncingTabLoadDataArea.CallBack {

    private View viewContext;
    private ViewGroup viewGroup;
    private View viewContent; // 内容布局
    private LayoutInflater inflater;

    private int height;

    // view
    private RecyclerView recyclerView;
    private TabAdapter tabAdapter;


    private BouncingTabMenu(@NonNull  View view, int layId, int height) {

        this.viewContext = view;
        this.height = height;

        inflater =LayoutInflater.from(view.getContext());
        //
        viewGroup = findParentLayout(view);
        //
        viewContent = inflater.inflate(R.layout.bouncing_titles_layout,
                viewGroup,false);
        recyclerView = viewContent.findViewById(R.id.bouncingRecyclerView);
    }

    //  找到跟布局
    private ViewGroup findParentLayout(@NonNull  View view) {

        do{
           if(view instanceof FrameLayout) {
               if(view.getId()==android.R.id.content){
                   return (ViewGroup) view;
               }
           }
           if(view!=null){

                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View)parent :null;
            }
        }while (view != null);

        return null;
    }

    /**
     *   public
     * **/

    public static BouncingTabMenu BouncingView(@NonNull  View view, int layId, int height) {

        return new BouncingTabMenu(view,layId,height);
    }

    public BouncingTabMenu showView() {

        ViewGroup.LayoutParams lp =  new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        viewGroup.addView(viewContent,lp);

        FrameLayout.LayoutParams  layoutParams = (FrameLayout.LayoutParams) viewContent.getLayoutParams();
        layoutParams.setMargins(0,116,0,0);
        viewContent.setLayoutParams(layoutParams);
        return this;
    }

    public void dismiss(){
        viewGroup.removeView(viewContent);
        viewContent = null;
    }

    //加载数据区
    public BouncingTabMenu loadData() {

       BouncingTabLoadDataArea.loadData(viewContext.getContext(),this).loadData();
       return this;
    }

    //显示区域
    public BouncingTabMenu showDatoToView() {

        GridLayoutManager manager=new GridLayoutManager(viewContext.getContext(),6);

        tabAdapter =new TabAdapter(viewContext.getContext(),dataListTabTiles);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(tabAdapter);
        return this;
    }

    List<TabTitlesData> dataListTabTiles;
    @Override
    public void callBackData(List<TabTitlesData> dataListTabTiles) {

       this.dataListTabTiles = dataListTabTiles;
    }

}
