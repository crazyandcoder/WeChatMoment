package com.crazyandcoder.tech.wechatmoments.utils.image.glide;

import android.content.Context;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.crazyandcoder.tech.wechatmoments.utils.image.BaseImageLoaderStrategy;
import com.crazyandcoder.tech.wechatmoments.utils.image.ImageConfigImpl;

/**
 * @ClassName: GlideImageLoaderStrategy
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 1:39 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 1:39 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl> {

    @Override
    public void displayImage(Context context, ImageConfigImpl config) {
        Glide.with(context).load(config.getUrl())// 加载图片
                .error(config.getPlaceholder())// 设置错误图片
                .placeholder(config.getPlaceholder())// 设置占位图
                .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存修改过的图片
                .into(config.getImageView());
    }

    @Override
    public void clear(@Nullable Context ctx, @Nullable ImageConfigImpl config) {

    }
}