package com.crazyandcoder.tech.wechatmoments.utils;

import android.annotation.SuppressLint;

import com.crazyandcoder.tech.wechatmoments.interfaces.OnTimerResultListener;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * @ClassName: TimerUtils
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 10:18 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 10:18 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TimerUtils {

    @SuppressLint("CheckResult")
    public static void timerTranslation(OnTimerResultListener onTimerResultListener) {
        Single.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(aLong -> {
            if (onTimerResultListener != null) {
                onTimerResultListener.onTimerResult();
            }
        });
    }
}
