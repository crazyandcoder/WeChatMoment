package com.crazyandcoder.tech.wechatmoments.mvp.presenter;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;
import com.crazyandcoder.tech.wechatmoments.http.ApiCallback;
import com.crazyandcoder.tech.wechatmoments.http.DataManager;
import com.crazyandcoder.tech.wechatmoments.mvp.interfaceCall.IWeChatMoments;
import com.crazyandcoder.tech.wechatmoments.mvp.base.BasePresenter;
import com.crazyandcoder.tech.wechatmoments.mvp.view.WeChatMomentsActivityView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: WeChatMomentsActivityPresenter
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 9:56 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 9:56 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WeChatMomentsActivityPresenter extends BasePresenter<WeChatMomentsActivityView> implements IWeChatMoments {

    private DataManager dataManager;

    public WeChatMomentsActivityPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getUserInfo(String username) {
        dataManager.getUserInfo(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiCallback<UserInfo>() {
                    @Override
                    public void onSuccess(UserInfo userInfo) {
                        getAttachedView().updateUserInfo(userInfo);
                    }

                    @Override
                    public void onFailure(String msg) {
                        getAttachedView().onFailure(msg);
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }

    @Override
    public void getTweets(String username) {
        dataManager.getTweets(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiCallback<List<Tweets>>() {
                    @Override
                    public void onSuccess(List<Tweets> tweetsList) {
                        getAttachedView().updateTweets(tweetsList);
                    }

                    @Override
                    public void onFailure(String msg) {
                        getAttachedView().onFailure(msg);
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }
}
