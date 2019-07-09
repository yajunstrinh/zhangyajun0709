package com.bawei.zhangyajun0709.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bawei.zhangyajun0709.R;
import com.bawei.zhangyajun0709.data.bean.HomeBean;
import com.bawei.zhangyajun0709.di.constans.IConstansHome;
import com.bawei.zhangyajun0709.di.presenter.IPresenterHome;
import com.bawei.zhangyajun0709.ui.adpater.BaseAdpater;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IConstansHome.IViewHome {

    @BindView(R.id.recycle_home)
    RecyclerView recycleHome;
    @BindView(R.id.sfl)
    SmartRefreshLayout sfl;
    private IPresenterHome iPresenterHome;
    private Context context;
    private BaseAdpater baseAdpater;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        //初始化P层
        iPresenterHome = new IPresenterHome();
        //绑定View层
        iPresenterHome.attachHome(this);
        iPresenterHome.getReshome(page);
        //设置上拉加载下拉刷新
        sfl.setRefreshHeader(new WaveSwipeHeader(this));
        sfl.setRefreshFooter(new FalsifyFooter(this));
        sfl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                iPresenterHome.getReshome(page);
                sfl.finishLoadMore();
            }
        });
        sfl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page++;
                iPresenterHome.getReshome(page);
                sfl.finishRefresh();
            }
        });
    }

    @Override
    public void showHome(HomeBean homeBean) {
        //解析
        List<HomeBean.ResultBean> result = homeBean.getResult();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleHome.setLayoutManager(manager);
        //适配器
        baseAdpater = new BaseAdpater(R.layout.item, result);
        recycleHome.setAdapter(baseAdpater);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenterHome.detachHome();
    }
}
