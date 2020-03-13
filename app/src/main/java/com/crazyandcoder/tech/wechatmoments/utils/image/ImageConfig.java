package com.crazyandcoder.tech.wechatmoments.utils.image;

import android.widget.ImageView;

/**
 * @ClassName: ImageConfig
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 1:34 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 1:34 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ImageConfig {
    protected String url;
    protected ImageView imageView;
    protected int placeholder;//占位符

    public String getUrl() {
        return url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPlaceholder() {
        return placeholder;
    }


}
