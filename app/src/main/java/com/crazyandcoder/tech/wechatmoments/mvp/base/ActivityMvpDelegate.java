package com.crazyandcoder.tech.wechatmoments.mvp.base;

import android.os.Bundle;

/**
 * @ClassName: ActivityMvpDelegate
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 9:34 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 9:34 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ActivityMvpDelegate <V extends MvpView,P extends MvpPresenter<V>> {

    void onCreate(Bundle bundle);

    void onDestroy();

}
