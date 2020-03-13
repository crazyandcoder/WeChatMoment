package com.crazyandcoder.tech.wechatmoments.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.crazyandcoder.tech.wechatmoments.R;

/**
 * @ClassName: TextClickSpan
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/13 9:39 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/13 9:39 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TextClickSpan extends ClickableSpan {

    private Context mContext;

    private String mUserName;
    private boolean mPressed;

    public TextClickSpan(Context context, String userName) {
        this.mContext = context;
        this.mUserName = userName;
    }

    public void setPressed(boolean isPressed) {
        this.mPressed = isPressed;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.bgColor = mPressed ? ContextCompat.getColor(mContext, R.color.base_B5B5B5) : Color.TRANSPARENT;
        ds.setColor(ContextCompat.getColor(mContext, R.color.base_697A9F));
        ds.setUnderlineText(false);
    }

    @Override
    public void onClick(View widget) {
//        Toast.makeText(mContext, "You Click " + mUserName, Toast.LENGTH_SHORT).show();
    }
}
