package com.crazyandcoder.tech.wechatmoments.mvp.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * @ClassName: ActivityMvpDelegateImpl
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 9:38 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 9:38 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ActivityMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements ActivityMvpDelegate {

    private MvpDelegateCallback<V, P> delegateCallback;
    private Activity activity;

    public ActivityMvpDelegateImpl(Activity activity, MvpDelegateCallback<V, P> delegateCallback) {
        this.delegateCallback = delegateCallback;
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle bundle) {
        P presenter = delegateCallback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException(
                    "Presenter returned from createPresenter() is null. Activity is " + activity);
        }

        delegateCallback.setPresenter(presenter);
        getMvpPresenter().attachView(getMvpView());

    }

    private V getMvpView() {
        V view = delegateCallback.getMvpView();
        if (view == null) {
            throw new NullPointerException("View returned from getMvpView() is null");
        }
        return view;
    }

    private P getMvpPresenter() {
        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from getPresenter() is null");
        }
        return presenter;
    }


    @Override
    public void onDestroy() {
        P presenter = getMvpPresenter();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
