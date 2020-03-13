package com.crazyandcoder.tech.wechatmoments.mvp.interfaceCall;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;

import java.util.List;

/**
 * @ClassName: IWeChatMoments
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/11 10:04 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 10:04 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IWeChatMoments {

    /**
     * 获取用户信息
     *
     * @param username
     */
    void getUserInfo(String username);

    /**
     * 获取朋友圈列表数据
     *
     * @param username
     */
    void getTweets(String username);
}
