package com.crazyandcoder.tech.wechatmoments.utils.image.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;

/**
 * @ClassName: GlideAppliesOptions
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 1:46 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 1:46 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface GlideAppliesOptions {
    /**
     * 配置 @{@link Glide} 的自定义参数,此方法在 @{@link Glide} 初始化时执行(@{@link Glide} 在第一次被调用时初始化),只会执行一次
     *
     * @param context
     * @param builder {@link GlideBuilder} 此类被用来创建 Glide
     */
    void applyGlideOptions(@NonNull Context context, @NonNull GlideBuilder builder);

    /**
     * 注册{@link Glide}的组件，参考{@link com.bumptech.glide.module.LibraryGlideModule}
     *
     * @param context  Android context
     * @param glide    {@link Glide}
     * @param registry {@link Registry}
     */
    void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry);
}
