package com.jd.lib.newcoupon.mvsp.p;

import com.jd.lib.newcoupon.mvsp.m.BaseModel;

/**
 * author:liudeyu on 2021/2/23
 */
public interface IPresenter<M extends BaseModel> {
    void onStateNotify(int state,M model);
}
