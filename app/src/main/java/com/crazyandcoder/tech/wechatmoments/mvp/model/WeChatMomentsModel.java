package com.crazyandcoder.tech.wechatmoments.mvp.model;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;
import com.crazyandcoder.tech.wechatmoments.http.DataManager;
import com.crazyandcoder.tech.wechatmoments.http.RetrofitHelper;
import com.crazyandcoder.tech.wechatmoments.http.ApiHelper;
import com.crazyandcoder.tech.wechatmoments.http.ApiService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @ClassName: WeChatMomentsModel
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/11 10:11 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 10:11 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WeChatMomentsModel implements ApiHelper {

    private DataManager manager;

    public WeChatMomentsModel() {
        manager = new DataManager();
    }

    @Override
    public Observable<UserInfo> getUserInfo(String name) {
        return manager.getUserInfo(name);
    }

    @Override
    public Observable<List<Tweets>> getTweets(String name) {
        return manager.getTweets(name);
    }
}
