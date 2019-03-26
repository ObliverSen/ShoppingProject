package com.shopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adapter.ShappingContentAdapter;
import com.adapter.TabAdapter;
import com.bean.ShoppingContentBean;
import com.bean.TabTitlesBean;
import com.bean.TabTitlesData;
import com.utils.LocalJsonResolutionUtils;
import com.widget.BouncingTabMenu;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by zhoushaosen on 2019/3/24.
 *
 * **
 *
 *
 * 框架还未搭好，只实现功能模块
 *
 */

public class ShoppingActivity  extends AppCompatActivity
                implements View.OnClickListener{

    private RecyclerView recyclerView;
    private TabAdapter tabAdapter;
    private ImageView imageView;
    private List<String> tabsTitlesList;
    private List<TabTitlesData>  dataListTabTiles;

    private View view;
    private LinearLayout titleLayout;
    private LinearLayout linearLayout;
    private RecyclerView xRecyclerView;
    private ShappingContentAdapter shappingContentAdapter;
    private List<String> listContent;

    private ShoppingContentBean bean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shapping_layout);

        initView();
        registerListener();
        //
        showTitles();
        showSelectionContent();
    }

    public void initView() {

        view = findViewById(R.id.line_view);
        titleLayout = findViewById(R.id.titleLayout);
        linearLayout = findViewById(R.id.shopping_layout);
        recyclerView = findViewById(R.id.tabs_recyclerView);
        imageView = findViewById(R.id.select_category_img);
        xRecyclerView = findViewById(R.id.xRecyclerView);

        tabsTitlesList=new ArrayList<>();
        listContent= new ArrayList<>();
    }

    public void registerListener() {
        imageView.setOnClickListener(this);
    }

    /**
     *  Tab titles
     * **/
    public void setTitlesInfo() {

        for(int i=0; i< 10 ; i++) {
            tabsTitlesList.add("标题 "+i);
        }
    }

    public void showTitles() {

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,0,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //setTitlesInfo();
        jsonData();
        tabAdapter=new TabAdapter(this, dataListTabTiles,recyclerView);
        recyclerView.setAdapter(tabAdapter);
    }

    /**
     *  显示内容
     * **/

    public void setContentList() {

        for(int i=0; i< 12; i++) {
            listContent.add("");
        }
    }

    public void showSelectionContent() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(linearLayoutManager);

        //setContentList();
        jsonContentData();
        shappingContentAdapter =
                new ShappingContentAdapter(this,bean);

        xRecyclerView.setAdapter(shappingContentAdapter);
    }

    // test
    BouncingTabMenu menu;
    boolean isOpen = false;
    @Override
    public void onClick(View v) {

        int id =v.getId();
        switch (id) {

            case R.id.select_category_img:

                if(!isOpen) {
                    isOpen = true;
                    Log.e("viewHeight","--> "+titleLayout.getMeasuredHeight());

                    menu = BouncingTabMenu.BouncingView(linearLayout,
                                            0,
                                            titleLayout.getMeasuredHeight(),
                                            recyclerView,
                                            tabAdapter).showView();
                    //
                    menu.loadData().showDatoToView();
                }else {
                    isOpen = false;
                    menu.dismiss();
                }

                break;
        }
    }

    // titles
    private void jsonData() {

        String img_json= LocalJsonResolutionUtils.getJson(this,"titles");
        dataListTabTiles = LocalJsonResolutionUtils.JsonToObject(img_json,TabTitlesBean.class).getData();
    }

    // content
    private void jsonContentData() {

        String img_json= LocalJsonResolutionUtils.getJson(this,"MainJson");
        //Log.e("====","=== "+img_json);
        bean = LocalJsonResolutionUtils.JsonToObject(img_json,ShoppingContentBean.class);
    }

}
