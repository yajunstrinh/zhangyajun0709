package com.bawei.zhangyajun0709;

import android.app.Application;
import android.content.Context;

/*
 *@Auther:张亚军
 *@Date: 2019/7/9
 *@Time:9:04
 *@Description:15901514581
 * */public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
