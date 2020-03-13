package com.crazyandcoder.tech.wechatmoments.mvp.base;

/**
 * @ClassName: BaseView
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 5:33 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 5:33 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BaseView extends MvpView{
    void showLoading();

    void hideLoading();
}
