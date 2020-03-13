package com.crazyandcoder.tech.wechatmoments.interfaces;

/**
 * @ClassName: OnPraiseOrCommentClickListener
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 6:20 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 6:20 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OnPraiseOrCommentClickListener {
    void onPraiseClick(int position);

    void onCommentClick(int position);
}
