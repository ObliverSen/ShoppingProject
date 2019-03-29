package com.shopping;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

/**
 * Created by zhoushaosen on 2019/3/27.
 *
 *
 */

public class GoodMenuActivity  extends AppCompatActivity {

    RecyclerView recyclerViewTitles;

    RecyclerView recyclerViewContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.avtivity_menu);
        init();
    }

    public void init() {

         recyclerViewTitles = findViewById(R.id.titles);
         recyclerViewContent = findViewById(R.id.contents);
    }




}
