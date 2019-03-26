package com.widget;

import android.content.Context;

import com.bean.TabTitlesBean;
import com.bean.TabTitlesData;
import com.utils.LocalJsonResolutionUtils;

import java.util.List;

/** test
 * Created by zhoushaosen on 2019/3/24.
 *
 */

public class BouncingTabLoadDataArea {

    private Context context;
    public CallBack callBack;

    private BouncingTabLoadDataArea(Context context,CallBack callBack) {

         this.context = context;
         this.callBack = callBack;
    }

    public void loadData() {

        String img_json= LocalJsonResolutionUtils.getJson(context,"AllTitles");
       // List<TabTitlesData> dataListTabTiles = LocalJsonResolutionUtils.JsonToObject(img_json,
         //                           TabTitlesBean.class).getData();
        callBack.callBackData(

                LocalJsonResolutionUtils.JsonToObject(img_json,
                        TabTitlesBean.class).getData()
        );
    }

    /**
     *  public
     * **/

    public static BouncingTabLoadDataArea loadData(Context context,CallBack callBack) {

        return new BouncingTabLoadDataArea(context,callBack);
    }

    public  interface CallBack {

        void callBackData(List<TabTitlesData> dataListTabTiles);
    }
}
