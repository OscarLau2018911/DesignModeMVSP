package com.oscarlau.designmode.mvsp.v;

import com.oscarlau.designmode.mvsp.m.BaseModel;

/**
 * author:liudeyu on 2021/2/23
 */
public interface IView<M extends BaseModel> {
    void onStateNotify(int state,M model);
}
