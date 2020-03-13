package com.crazyandcoder.tech.wechatmoments.bean;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

import com.crazyandcoder.tech.wechatmoments.config.Constants;
import com.crazyandcoder.tech.wechatmoments.interfaces.TranslationState;
import com.crazyandcoder.tech.wechatmoments.widget.TextClickSpan;

/**
 * @ClassName: CommentBean
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/13 10:52 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/13 10:52 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CommentBean {
    private int commentType;

    private String commentUser;

    private String commentContent;

    private TranslationState translationState = TranslationState.START;

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public TranslationState getTranslationState() {
        return translationState;
    }

    public void setTranslationState(TranslationState translationState) {
        this.translationState = translationState;
    }

    /**
     * 富文本内容
     */
    private SpannableStringBuilder commentContentSpan;

    public SpannableStringBuilder getCommentContentSpan() {
        return commentContentSpan;
    }

    public void build(Context context) {
        if (commentType == Constants.CommentType.COMMENT_TYPE_SINGLE) {
            String richText = String.format("%s: %s", commentUser, commentContent);
            SpannableStringBuilder builder = new SpannableStringBuilder(richText);
            if (!TextUtils.isEmpty(commentUser)) {
                builder.setSpan(new TextClickSpan(context, commentUser), 0, commentUser.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            commentContentSpan = builder;
        }
    }

}
