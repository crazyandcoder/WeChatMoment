package com.crazyandcoder.tech.wechatmoments.widget.swipefresh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
/**
 * @ClassName: CustomProgressDrawable
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/13 11:21 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/13 11:21 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CustomProgressDrawable extends MaterialProgressDrawable{

    //    旋转因子，调整旋转速度
    private static final int ROTATION_FACTOR = 5*360;
    //    加载时的动画
    private Animation mAnimation;
    private View mParent;
    private Bitmap mBitmap;
    //    旋转角度
    private float rotation;
    private Paint paint;

    public CustomProgressDrawable(Context context, View parent) {
        super(context, parent);
        mParent = parent;
        paint = new Paint();
        setupAnimation();
        setBackgroundColor(Color.WHITE);
    }

    private void setupAnimation() {
//        初始化旋转动画
        mAnimation = new Animation(){
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                setProgressRotation(-interpolatedTime);
            }
        };
        mAnimation.setDuration(5000);
//        无限重复
        mAnimation.setRepeatCount(Animation.INFINITE);
        mAnimation.setRepeatMode(Animation.RESTART);
//        均匀转速
        mAnimation.setInterpolator(new LinearInterpolator());
    }

    @Override
    public void start() {
        mParent.startAnimation(mAnimation);
    }
    public void setBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }


    @Override
    public void setProgressRotation(float rotation) {
//        取负号是为了和微信保持一致，下拉时逆时针转加载时顺时针转，旋转因子是为了调整转的速度。
        this.rotation = -rotation*ROTATION_FACTOR;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas c) {
        Rect bound = getBounds();
        c.rotate(rotation,bound.exactCenterX(),bound.exactCenterY());
        Rect src = new Rect(0,0,mBitmap.getWidth(),mBitmap.getHeight());
        c.drawBitmap(mBitmap,src,bound,paint);
    }
}