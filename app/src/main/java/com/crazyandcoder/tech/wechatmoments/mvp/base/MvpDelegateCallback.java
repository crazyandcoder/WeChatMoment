package com.crazyandcoder.tech.wechatmoments.mvp.base;

/**
 * @ClassName: MvpDelegateCallback
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 5:53 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 5:53 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {

    P createPresenter();

    P getPresenter();

    void setPresenter(P presenter);

    V getMvpView();
}
