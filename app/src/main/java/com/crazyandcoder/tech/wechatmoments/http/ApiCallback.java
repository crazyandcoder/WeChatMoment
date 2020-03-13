package com.crazyandcoder.tech.wechatmoments.http;

import android.util.Log;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * @ClassName: ApiCallback
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/11 1:48 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 1:48 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class ApiCallback<T> extends DisposableObserver<T> {
    public abstract void onSuccess(T model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = httpException.getMessage();
            onFailure("error: code" + code + "  msg: " + msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
