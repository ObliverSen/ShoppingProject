//package com.shopping;
//
//import android.content.Context;
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.TextSwitcher;
//import android.widget.TextView;
//import android.widget.ViewSwitcher;
//
//import com.adapter.MianAdapter;
//import com.adapter.ShowTitles;
//import com.bean.MainImgBean;
//import com.jcodecraeer.xrecyclerview.XRecyclerView;
//import com.threads.MainTitlesThread;
//import com.utils.LocalJsonResolutionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    // 头部
//    private View headView;
//    public TextSwitcher textSwitcher_today;
//    public TextSwitcher textSwitcher_yesterday;
//    private RecyclerView recyclerView;
//    private List<String> title = new ArrayList<>();
//    private ShowTitles showTitles;
//
//    // 循环数据
//    private MainTitlesThread mainTitlesThread;
//    public Handler handler= new Handler();
//
//    // 主页
//    private XRecyclerView xRecyclerView;
//    private MianAdapter mianAdapter;
//
//    //private List<MainImgBean> list;
//
//    private MainImgBean bean= null;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initHeadHeadView();
//        initMainData();
//    }
//
//    public void initHeadHeadView() {
//
//        headView = LayoutInflater.from(this).inflate(R.layout.head_layouot,null);
//        textSwitcher_today = headView.findViewById(R.id.today_switcher);
//        textSwitcher_yesterday = headView.findViewById(R.id.yesterday_switcher);
//        recyclerView = headView.findViewById(R.id.tabs_first);
//
//        initTodeyList();
//        updateNote();
//        setDatasToRecy();
//    }
//
//    //
//    public void setDatasToRecy() {
//
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,0,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        setTitle();
//        showTitles = new ShowTitles(this,title);
//        recyclerView.setAdapter(showTitles);
//    }
//
//    public void initMainData() {
//
//        LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(this);
//        xRecyclerView = findViewById(R.id.shopping_content);
//        xRecyclerView.setLayoutManager(linearLayoutManager);
//
//        //xRecyclerView.setPullRefreshEnabled(true);
//
//        // 添加请求头
//        xRecyclerView.addHeaderView(headView);
//
//        //list = new ArrayList<>();
//        //
//        //listData();
//        parseJson();
//        //
//        mianAdapter=new MianAdapter(this,bean);
//        xRecyclerView.setAdapter(mianAdapter);
//    }
//
//    // 解析json数据
//    public void parseJson() {
//
//      String img_json= LocalJsonResolutionUtils.getJson(this,"MainJson");
//      Log.e("====","=== "+img_json);
//      bean = LocalJsonResolutionUtils.JsonToObject(img_json,MainImgBean.class);
//    }
//
//    private void listData() {
//
//        for(int i=0; i< 30; i++) {
//         //   list.add("篮球鞋品牌/跑鞋品牌 "+i);
//        }
//    }
//
//    // 设置显示标题
//    public void setTitle() {
//
//        for(int i=0; i<16; i++) {
//
//            title.add("服装"+i+"号  ");
//        }
//    }
//
//
//    /** TestSwitcher
//     *  list 集合 今日
//     * **/
//
//    public void initTodeyList() {
//
//        Log.e("textSwitcher_today","--  "+textSwitcher_today);
//        textSwitcher_today.setFactory(new SwitchFactory(this,"冰箱/电视/洗衣机"));
//        setTextSwitcherAnimaiton(textSwitcher_today);
//
//        initYesterDayList();
//    }
//
//    /**
//     *  TestSwitcher
//     *
//     *  List 集合 昨日
//     * **/
//
//    public void initYesterDayList() {
//
//        Log.e("textSwitcher_today","--2  "+textSwitcher_yesterday);
//        textSwitcher_yesterday.setFactory(new SwitchFactory(this,"男上衣/鞋子/帽子"));
//        setTextSwitcherAnimaiton(textSwitcher_yesterday);
//    }
//
//    //进入动画
//    public void setTextSwitcherAnimaiton(TextSwitcher textSwitcher) {
//
//        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.text_switch_in);
//        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.text_switch_out);
//        textSwitcher.setInAnimation(loadAnimation);
//        textSwitcher.setOutAnimation(loadAnimation2);
//    }
//
//    /**
//     * 循环内容
//     * **/
//    private class SwitchFactory implements ViewSwitcher.ViewFactory{
//
//        private Context context;
//        private String str;
//
//        public SwitchFactory(Context context,String str) {
//
//            this.context = context;
//            this.str = str;
//        }
//
//        @Override
//        public View makeView() {
//
//            TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.switcher_textview,null);
//            textView.setText(str);
//            return textView;
//        }
//    }
//
//    //开启循环内容
//    public void updateNote() {
//
//        mainTitlesThread = new MainTitlesThread(this,3000L);
//        handler.post(mainTitlesThread);
//    }
//
//}
