package com.crazyandcoder.tech.wechatmoments.mvp.base;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;

/**
 * @ClassName: MvpPresenter
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 5:40 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 5:40 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface MvpPresenter<V extends MvpView> {

    @UiThread
    void attachView(@NonNull V view);

    @UiThread
    void detachView();

    @UiThread
    V getAttachedView();

}
