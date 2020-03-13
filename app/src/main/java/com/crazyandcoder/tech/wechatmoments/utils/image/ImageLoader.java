package com.crazyandcoder.tech.wechatmoments.utils.image;

import android.content.Context;

/**
 * @ClassName: ImageLoader
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 10:10 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 10:10 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ImageLoader {

    private BaseImageLoaderStrategy mStrategy;

    /**
     * 加载图片
     */
    public <T extends ImageConfig> void loadImage(Context context, T config) {
        if (this.mStrategy == null) {
            throw new
                    NullPointerException("you should invoke setLoadImgStrategy first");
        }
        this.mStrategy.displayImage(context, config);
    }

    //设置上你的策略实现类对象，让它去调自己的displayImage()方法
    public void setLoadImgStrategy(BaseImageLoaderStrategy strategy) {
        this.mStrategy = strategy;
    }

    public BaseImageLoaderStrategy getLoadImgStrategy() {
        return mStrategy;
    }
}
