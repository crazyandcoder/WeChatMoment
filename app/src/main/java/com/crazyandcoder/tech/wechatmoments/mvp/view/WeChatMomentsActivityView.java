package com.crazyandcoder.tech.wechatmoments.mvp.view;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;
import com.crazyandcoder.tech.wechatmoments.mvp.base.MvpView;

import java.util.List;

/**
 * @ClassName: WeChatMomentsActivityView
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 9:55 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 9:55 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface WeChatMomentsActivityView extends MvpView {
    /**
     * 设置用户信息
     *
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 获取朋友圈列表数据
     *
     * @param tweetsList
     */
    void updateTweets(List<Tweets> tweetsList);
}
