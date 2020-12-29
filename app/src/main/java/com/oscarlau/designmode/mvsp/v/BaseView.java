package com.oscarlau.designmode.mvsp.v;

import com.oscarlau.designmode.mvsp.m.BaseModel;
import com.oscarlau.designmode.mvsp.p.BasePresenter;
import com.oscarlau.designmode.mvsp.s.BaseState;

/**
 * author:liudeyu on 2020/12/29
 */
public abstract class BaseView<S extends BaseState,M extends BaseModel> implements BaseState.notifyStateToV{
    private BaseState S;
    private BaseModel M;

    public BaseView(){
        setS(createState());
        if (getS() != null) {
            getS().attach(this);
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
    //创建state
    abstract BaseState createState();
}
