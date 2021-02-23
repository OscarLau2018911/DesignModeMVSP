package com.oscarlau.designmode.mvsp.p;

import com.oscarlau.designmode.mvsp.m.BaseModel;
import com.oscarlau.designmode.mvsp.s.BaseState;

/**
 * author:liudeyu on 2020/12/29
 */
public abstract class BasePresenter<S extends BaseState,M extends BaseModel> implements implements IPresenter<M>{
    private S S;
    private M M;
    //持有state实例
    public void attach(S state){
        setS(state);
    }
    //释放state实例
    public void dettach(){
        setS(null);
    }
    //告知V state状态改变
    public void notifyStateToV(int state){
        notifyStateToV(state,null);
    }
    //告知V state状态改变
    public void notifyStateToV(int state,BaseModel model){
        if (getS() != null){
            getS().setStateToV(state,model);
        }
    }

    public S getS() {
        return S;
    }

    public void setS(S s) {
        S = s;
    }

    public M getM() {
        return M;
    }

    public void setM(M m) {
        M = m;
    }
}
