package com.jd.lib.newcoupon.mvsp.s;

import com.jd.lib.newcoupon.mvsp.m.BaseModel;

/**
 * author:liudeyu on 2021/2/23
 */
public interface IState<M extends BaseModel> {
    void setStateToV(int state,M model);
    void setStateToP(int state,M model);
}
