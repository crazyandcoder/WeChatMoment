package com.crazyandcoder.tech.wechatmoments.http;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @ClassName: ApiHelper
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/11 10:13 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 10:13 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ApiHelper {

    //获取用户信息
    Observable<UserInfo> getUserInfo(String name);

    //获取朋友圈列表数据
    Observable<List<Tweets>> getTweets(String name);
}
