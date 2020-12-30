package com.oscarlau.designmode.mvsp.s;

import com.oscarlau.designmode.mvsp.m.BaseModel;
import com.oscarlau.designmode.mvsp.p.BasePresenter;

/**
 * author:liudeyu on 2020/12/29
 */
public abstract class BaseState<P extends BasePresenter,M extends BaseModel> {
    private notifyStateToV V;
    private int S;
    private BaseModel M;
    private BasePresenter P;

    public BaseState(){
        setP(createPresenter());
        if (getP() != null){
            getP().attach(this);
        }
    }
    //持有view实例
    public void attach(notifyStateToV view){
        setV(view);
    }
    //释放view实例
    public void dettach(){
        setV(null);
    }
    //presenter调用设置状态&数据接口
    public void setStateToV(int state,BaseModel model){
        setS(state);
        setM(model);
        if (getV() != null){
            //此处如果存在观察者view，就回调给view处理
            getV().onStateNotifyOnV(state,model);
        }
    }
    //view调用设置状态&数据接口
    public void setStateToP(int state,BaseModel model){
        setS(state);
        setM(model);
        if (getP() != null){
            //此处如果存在观察者view，就回调给view处理
            getP().onStateNotifyOnP(state,model);
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
    //观察state状态的继承接口--for view
    public interface notifyStateToV{
        void onStateNotifyOnV(int state,BaseModel model);
    }
    //观察state状态的继承接口--for presenter
    public interface notifyStateToP{
        void onStateNotifyOnP(int state,BaseModel model);
    }
    //创建presenter
    public abstract BasePresenter createPresenter();

    public notifyStateToV getV() {
        return V;
    }

    public void setV(notifyStateToV v) {
        V = v;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public BaseModel getM() {
        return M;
    }

    public void setM(BaseModel m) {
        M = m;
    }

    public BasePresenter getP() {
        return P;
    }

    public void setP(BasePresenter p) {
        P = p;
    }
}
