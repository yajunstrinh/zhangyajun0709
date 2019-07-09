package com.bawei.zhangyajun0709.di.model;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhangyajun0709.App;
import com.bawei.zhangyajun0709.data.bean.HomeBean;
import com.bawei.zhangyajun0709.di.cons.Cons;
import com.bawei.zhangyajun0709.di.constans.IConstansHome;
import com.google.gson.Gson;

/*
 *@Auther:张亚军
 *@Date: 2019/7/9
 *@Time:8:57
 *@Description:15901514581
 * */public class IModelHome implements IConstansHome.IModel {
    @Override
    public void resHome(int page,final CallBackHome callBackHome) {
        RequestQueue requestQueue = Volley.newRequestQueue(App.context);
        StringRequest stringRequest = new StringRequest(Cons.LIE_URL+page, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HomeBean homeBean = gson.fromJson(response, HomeBean.class);
                callBackHome.reponHome(homeBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
