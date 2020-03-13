package com.crazyandcoder.tech.wechatmoments.utils.image;

import android.widget.ImageView;

/**
 * @ClassName: ImageConfigImpl
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 1:35 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 1:35 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ImageConfigImpl extends ImageConfig {
    private int imageRadius;//图片每个圆角的大小
    private int blurValue;//高斯模糊值, 值越大模糊效果越大

    //建造者模式来构建配置信息这个对象
    private ImageConfigImpl(Builder builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.imageRadius = builder.imageRadius;
        this.blurValue = builder.blurValue;
    }

    public int getBlurValue() {
        return blurValue;
    }

    public int getImageRadius() {
        return imageRadius;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String url;
        private ImageView imageView;
        private int imageRadius;//图片每个圆角的大小
        private int blurValue;//高斯模糊值, 值越大模糊效果越大
        private int placeholder;

        private Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder placeholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Builder imageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder imageRadius(int imageRadius) {
            this.imageRadius = imageRadius;
            return this;
        }

        public Builder blurValue(int blurValue) { //blurValue 建议设置为 15
            this.blurValue = blurValue;
            return this;
        }

        //构造出ImageConfigImpl对象
        public ImageConfigImpl build() {
            return new ImageConfigImpl(this);
        }
    }
}
