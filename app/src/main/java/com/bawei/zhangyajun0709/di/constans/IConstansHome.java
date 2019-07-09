package com.bawei.zhangyajun0709.di.constans;

import com.bawei.zhangyajun0709.data.bean.HomeBean;

/*
 *@Auther:张亚军
 *@Date: 2019/7/9
 *@Time:8:52
 *@Description:15901514581
 * */public interface IConstansHome {
    /**
     * View层
     */
    public interface IViewHome{
         public void showHome(HomeBean homeBean);
     }

    /**
     * P层
     * @param <IViewHome>
     */
     public interface IPresenter<IViewHome>{
         //关联
        public void attachHome(IViewHome iViewHome);
        //解绑
        public void detachHome();
        public void getReshome(int page);
     }

    /**
     * M层
     */
    public interface IModel{
        public void resHome(int page,CallBackHome callBackHome);
        public interface CallBackHome{
            public void reponHome(HomeBean homeBean);
        }
     }
}
