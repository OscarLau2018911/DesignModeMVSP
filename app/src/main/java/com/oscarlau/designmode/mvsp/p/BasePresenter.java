package com.oscarlau.designmode.mvsp.p;

import com.oscarlau.designmode.mvsp.m.BaseModel;
import com.oscarlau.designmode.mvsp.s.BaseState;

/**
 * author:liudeyu on 2020/12/29
 */
public abstract class BasePresenter<S extends BaseState,M extends BaseModel> implements BaseState.notifyStateToP{
    private BaseState S;
    private BaseModel M;
    //持有state实例
    public void attach(BaseState state){
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

    public BaseState getS() {
        return S;
    }

    public void setS(BaseState s) {
        S = s;
    }

    public BaseModel getM() {
        return M;
    }

    public void setM(BaseModel m) {
        M = m;
    }
}
