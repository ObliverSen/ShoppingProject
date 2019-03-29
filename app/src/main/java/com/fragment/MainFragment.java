package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adapter.DetailsAdapter;
import com.shopping.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoushaosen on 2019/3/28.
 *
 */

public class MainFragment  extends Fragment {

    private AppBarLayout appbar_layout;
    private RecyclerView recyclerView;
    private DetailsAdapter detailsAdapter;

    private List<String> list=new ArrayList<>();
    private float i;
    private TabBarListener tabBarListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fg_details,container,false);
        initView(view);
        return view;
    }

    public void initView(View view) {

        appbar_layout = view.findViewById(R.id.appbar_layout);
        recyclerView = view.findViewById(R.id.recyclerView);
        initListData();
        detailsAdapter = new DetailsAdapter(getActivity(),list);

        this.recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(detailsAdapter);

        // listener
        setAppbarLayoutScrollListener();
    }

    public void initListData() {

        for(int i=0; i< 40; i++) {
            list.add("");
        }
    }

    // -----

    private void setAppbarLayoutScrollListener() {

        this.appbar_layout.setExpanded(true, true);
        this.appbar_layout.addOnOffsetChangedListener
                (new AppBarLayoutListener());
    }

    private  class AppBarLayoutListener implements AppBarLayout.OnOffsetChangedListener{

        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

            i = ((float) Math.abs(verticalOffset)) / ((float) appBarLayout.getTotalScrollRange());
            tabBarListener.ofChange(i);
        }
    }

    public void setTabBarListener(TabBarListener tabBarListener) {

        this.tabBarListener= tabBarListener;
    }

    public interface TabBarListener {

        void ofChange(float f);
    }


}
