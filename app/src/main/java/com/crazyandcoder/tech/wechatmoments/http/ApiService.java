package com.crazyandcoder.tech.wechatmoments.http;

import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @ClassName: ApiService
 * @Description: 统一定义网络请求的接口申明
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 3:38 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 3:38 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ApiService {

    @GET("user/{name}")
    Observable<UserInfo> getUserInfo(@Path("name") String name);

    @GET("user/{name}/tweets")
    Observable<List<Tweets>> getTweets(@Path("name") String name);

}
