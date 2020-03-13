package com.crazyandcoder.tech.wechatmoments;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 5:08 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 5:08 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyApplication extends MultiDexApplication {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
}
