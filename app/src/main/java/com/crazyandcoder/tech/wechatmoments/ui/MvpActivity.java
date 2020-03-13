package com.crazyandcoder.tech.wechatmoments.ui;

import android.support.annotation.NonNull;
import android.os.Bundle;

import com.crazyandcoder.tech.wechatmoments.http.DataManager;
import com.crazyandcoder.tech.wechatmoments.mvp.base.ActivityMvpDelegate;
import com.crazyandcoder.tech.wechatmoments.mvp.base.ActivityMvpDelegateImpl;
import com.crazyandcoder.tech.wechatmoments.mvp.base.MvpDelegateCallback;
import com.crazyandcoder.tech.wechatmoments.mvp.base.MvpPresenter;
import com.crazyandcoder.tech.wechatmoments.mvp.base.MvpView;

public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends BaseActivity implements MvpDelegateCallback<V, P> {

    protected P presenter;
    protected ActivityMvpDelegate activityMvpDelegate = null;
    protected DataManager dataManager=new DataManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getActivityMvpDelegate().onDestroy();

    }

    @NonNull
    @Override
    public abstract P createPresenter();


    @NonNull
    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public V getMvpView() {
        return (V) this;
    }

    @NonNull
    protected ActivityMvpDelegate<V, P> getActivityMvpDelegate() {
        if (activityMvpDelegate == null) {
            activityMvpDelegate = new ActivityMvpDelegateImpl(this, this);
        }
        return activityMvpDelegate;
    }

}
