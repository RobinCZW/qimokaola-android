package com.example.robin.papers.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.robin.papers.R;
import com.example.robin.papers.demo.adapter.MyGridAdapter;
import com.example.robin.papers.demo.util.MyGridView;

public class FragmentService extends Fragment{

    private MyGridView gridview_services,gridView_links;


    //福大服务的名字
    public String[] text_service = { "上传资源","成绩查询", "视频海报", "打印上门",  "器材正装", "表白神器",
             "服务入驻" ,"建议反馈","敬请期待"};
    //福大服务是网页还是本地activity  1为网页 2为activity 3是无响应
    public int[] serviceWebOrActivity = {1,1,1,1,1,1,1,1,3};
    //福大服务的图标
    public int[] imgs_service = {
            R.drawable.cim,
            R.drawable.zcpm,
            R.drawable.notcat,
            R.drawable.ydy,
            R.drawable.hdqczl,
            R.drawable.fxq,
            R.drawable.jyhhz,
            R.drawable.tousu,
            R.drawable.nothingicon
    };
    //福大服务的网页路径
    public String[] urls_service = {
            "http://robinchen.mikecrm.com/f.php?t=ZmhFim",
            "http://112.124.54.19/Score/index.html?identity=3ABD9A9A6B4622BEFDD35CA21905C0CB",
            "http://form.mikecrm.com/f.php?t=HIJjLT",//不是猫
            "http://form.mikecrm.com/f.php?t=l7zy0t",
            "http://form.mikecrm.com/f.php?t=jFGpR4",
            "http://form.mikecrm.com/f.php?t=Q8R9Ag",
            "http://robinchen.mikecrm.com/f.php?t=ahOWL2",
            "http://robinchen.mikecrm.com/f.php?t=Fc00ps"
    };


    //友情链接的图标和名字
    public String[] text_links = { "Papers官网","空教室查询","百度翻译","新庭芳苑", "福大易班" ,"申请友链"
            };
    //友情链接是网页还是本地activity  1为网页 2为activity 3是无响应
    public int[] linksWebOrActivity = {1,1,1,1,1,1};
    public int[] imgs_links = { R.drawable.home,
            R.drawable.kong,
            R.drawable.service_icon_translation,
            R.drawable.xtfy,
            R.drawable.yb,
            R.drawable.youlian
            };
    public String[] urls_links = {
            "http://fzu2016.com/",
            "http://112.124.56.216:8080/Super/emptyClass/index.html?identity=3ABD9A9A6B4622BEFDD35CA21905C0CB",
            "http://fanyi.baidu.com/",
            "http://bbs.fzu.edu.cn/forum.php?forumlist=1&mobile=2",
            "http://59.77.233.33/",
            "http://robinchen.mikecrm.com/f.php?t=foqK6Y"
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_me,container,false);

        gridview_services =(MyGridView) view.findViewById(R.id.gridviewServices);
        gridView_links = (MyGridView) view.findViewById(R.id.gridviewLinks);

        gridview_services.setAdapter(new MyGridAdapter(getActivity(), text_service, imgs_service));
        gridView_links.setAdapter(new MyGridAdapter(getActivity(), text_links, imgs_links));

        //gridview监听事件
        gridview_services.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (serviceWebOrActivity[position]==1) {
                    //跳转至web
                    Intent toWebIntent = new Intent(getActivity(), WebViewActivity.class);
                    toWebIntent.putExtra("url", urls_service[position]);
                    toWebIntent.putExtra("title", text_service[position]);
                    startActivity(toWebIntent);
                } else if (serviceWebOrActivity[position]==2){
                    //跳转到activity
                    if (text_service[position].equals("单期绩点")){
                        startActivity(new Intent(getActivity(),SinglePeriodGPA.class));
                    }
                }else if (serviceWebOrActivity[position]==3){
                    //无响应
                }
            }
        });

        //gridView_links监听事件
        gridView_links.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (linksWebOrActivity[position]==1){
                    //跳转至web
                    Intent toWebIntent = new Intent(getActivity(), WebViewActivity.class);
                    toWebIntent.putExtra("url", urls_links[position]);
                    toWebIntent.putExtra("title",text_links[position]);
                    startActivity(toWebIntent);
                }else if (linksWebOrActivity[position]==2){
                    //跳转到activity
                }else if (linksWebOrActivity[position]==3){
                    //无响应
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

    }

}