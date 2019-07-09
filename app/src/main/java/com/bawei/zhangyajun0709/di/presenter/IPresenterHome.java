package com.bawei.zhangyajun0709.di.presenter;

import com.bawei.zhangyajun0709.data.bean.HomeBean;
import com.bawei.zhangyajun0709.di.constans.IConstansHome;
import com.bawei.zhangyajun0709.di.model.IModelHome;

/*
 *@Auther:张亚军
 *@Date: 2019/7/9
 *@Time:8:57
 * P层
 *@Description:15901514581
 * */public class IPresenterHome implements IConstansHome.IPresenter<IConstansHome.IViewHome> {
     IConstansHome.IViewHome iViewHome;
    private IModelHome iModelHome;

    @Override
    public void attachHome(IConstansHome.IViewHome iViewHome) {
           this.iViewHome=iViewHome;
        iModelHome = new IModelHome();
    }

    @Override
    public void detachHome() {
         iModelHome=null;
    }

    @Override
    public void getReshome(int page) {
       iModelHome.resHome(page,new IConstansHome.IModel.CallBackHome() {
           @Override
           public void reponHome(HomeBean homeBean) {
               iViewHome.showHome(homeBean);
           }
       });
    }
}
