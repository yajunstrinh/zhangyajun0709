package com.bawei.zhangyajun0709.ui.adpater;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bawei.zhangyajun0709.R;
import com.bawei.zhangyajun0709.data.bean.HomeBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*
 *@Auther:张亚军
 *@Date: 2019/7/9
 *@Time:9:08
 * 适配器
 *@Description:15901514581
 * */   public class BaseAdpater extends BaseQuickAdapter<HomeBean.ResultBean,BaseViewHolder> {
    public BaseAdpater(int layoutResId, @Nullable List<HomeBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.ResultBean item) {
          helper.setText(R.id.home_text,item.getCommodityName());
        ImageView view = helper.getView(R.id.home_image);
        Glide.with(mContext).load(item.getMasterPic()).into(view);
    }
}
