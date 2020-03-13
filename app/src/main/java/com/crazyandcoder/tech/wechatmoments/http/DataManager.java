package com.crazyandcoder.tech.wechatmoments.http;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @ClassName: DataManager
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/11 11:40 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 11:40 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataManager implements ApiHelper {
    private ApiService apiService;
    private Retrofit mRetrofit;

    public DataManager() {
        mRetrofit = RetrofitHelper.getRetrofit();
        apiService = mRetrofit.create(ApiService.class);
    }

    @Override
    public Observable<UserInfo> getUserInfo(String name) {
        return apiService.getUserInfo(name);
    }

    @Override
    public Observable<List<Tweets>> getTweets(String name) {
        return apiService.getTweets(name);
    }

}
