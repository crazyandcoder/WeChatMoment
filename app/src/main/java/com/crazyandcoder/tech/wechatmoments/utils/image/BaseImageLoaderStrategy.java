package com.crazyandcoder.tech.wechatmoments.utils.image;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * @ClassName: BaseImageLoaderStrategy
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 1:38 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 1:38 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BaseImageLoaderStrategy<T extends ImageConfig> {
    /**
     * 加载图片
     *
     * @param ctx    {@link Context}
     * @param config 图片加载配置信息
     */
    void displayImage(@Nullable Context ctx, @Nullable T config);
    /**
     * 停止加载
     *
     * @param ctx    {@link Context}
     * @param config 图片加载配置信息
     */
    void clear(@Nullable Context ctx, @Nullable T config);
}
