package com.oscarlau.designmode.mvsp.v;

import com.oscarlau.designmode.mvsp.m.BaseModel;
import com.oscarlau.designmode.mvsp.p.BasePresenter;
import com.oscarlau.designmode.mvsp.s.BaseState;

/**
 * author:liudeyu on 2020/12/29
 */
public abstract class BaseView<S extends BaseState,M extends BaseModel> implements IView<M>{
    private S S;
    private M M;

    public BaseView(){
        setS(createState());
        if (getS() != null) {
            getS().attach(this);
        }
    }
    //告知P state状态改变
    public void notifyStateToP(int state){
        notifyStateToP(state,null);
    }
    //告知P state状态改变
    public void notifyStateToP(int state,BaseModel model){
        if (getS() != null){
            getS().setStateToP(state,model);
        }
    }
    //创建state
    public abstract S createState();

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
