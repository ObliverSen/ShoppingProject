package com.widget;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.shopping.R;

/**
 * Created by zhoushaosen on 2019/3/24.
 *
 *
 */

public class BouncingTitleMenu {

    private ViewGroup viewGroup;
    private View viewContent; // 内容布局
    private LayoutInflater inflater;

    private int height;

    private BouncingTitleMenu(@NonNull  View view,int layId,int height) {

        this.height = height;

        inflater =LayoutInflater.from(view.getContext());
        //
        viewGroup = findParentLayout(view);
        //
        viewContent = inflater.inflate(R.layout.bouncing_titles_layout,
                viewGroup,false);
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
     *
     * **/

    public static BouncingTitleMenu BouncingView(@NonNull  View view,int layId,int height) {

        return new BouncingTitleMenu(view,layId,height);
    }



    public BouncingTitleMenu showView() {

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

}
