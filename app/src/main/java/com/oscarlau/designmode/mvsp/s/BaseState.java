package com.oscarlau.designmode.mvsp.s;

import com.oscarlau.designmode.mvsp.m.BaseModel;
import com.oscarlau.designmode.mvsp.p.BasePresenter;

/**
 * author:liudeyu on 2020/12/29
 */
public abstract class BaseState<P extends BasePresenter,M extends BaseModel> implements IState<M>{
    private BaseView V;
    private int state;
    private P P;

    public BaseState(){
        setP(createPresenter());
        if (getP() != null){
            getP().attach(this);
        }
    }
    //持有view实例
    public void attach(BaseView view){
        setV(view);
    }
    //释放view实例
    public void dettach(){
        setV(null);
    }
    //presenter调用设置状态&数据接口
    @Override
    public void setStateToV(int state,M model){
        setState(state);
        try {
            if (getV() != null) {
                //此处如果存在观察者view，就回调给view处理
                getV().setM(model);
                getV().onStateNotify(state, model);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //view调用设置状态&数据接口
    @Override
    public void setStateToP(int state,M model){
        setState(state);
        try {
            if (getP() != null) {
                //此处如果存在观察者view，就回调给view处理
                getP().setM(model);
                getP().onStateNotify(state, model);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //presenter调用设置状态接口
    public void setStateToV(int state){
        setStateToV(state,null);
    }
    //view调用设置状态接口
    public void setStateToP(int state){
        setStateToP(state,null);
    }
    //创建presenter
    public abstract P createPresenter();

    public BaseView getV() {
        return V;
    }

    public void setV(BaseView v) {
        V = v;
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        state = s;
    }

    public P getP() {
        return P;
    }

    public void setP(P p) {
        P = p;
    }
}
