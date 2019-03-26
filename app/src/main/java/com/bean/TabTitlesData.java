package com.bean;

/**
 * Created by zhoushaosen on 2019/3/24.
 */

public class TabTitlesData {

   /**       "electricAppliance":"电器",

             "shenghuo":"生活",

             "home":"家庭",

             "school":"学校",

             "factory":"公司",

             "book":"书本",

             "room":"房屋",

             "phone":"手机",

             "vegetables":"蔬菜",

             "fruit":"水果"

    **/

   private String name;

   private boolean isSelect = false;

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public String getName() {
        return name;
    }
}
