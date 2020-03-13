package com.crazyandcoder.tech.wechatmoments.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

import com.crazyandcoder.tech.wechatmoments.R;
import com.crazyandcoder.tech.wechatmoments.bean.CommentBean;
import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.config.Constants;
import com.crazyandcoder.tech.wechatmoments.widget.TextClickSpan;
import com.crazyandcoder.tech.wechatmoments.widget.VerticalImageSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DataUtils
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/13 9:35 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/13 9:35 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataUtils {

    /**
     * 获取点赞的人
     *
     * @param context
     * @param commentsList
     * @return
     */
    public static SpannableStringBuilder getPraisePeople(Context context, List<Tweets.Comments> commentsList) {

        if (commentsList == null || commentsList.size() == 0) return null;
        List<Tweets.Sender> senderList = new ArrayList<>();
        for (Tweets.Comments comment : commentsList) {
            senderList.add(comment.getSender());
        }
        if (senderList != null && senderList.size() > 0) {
            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append("  ");

            int size = senderList.size();
            for (int i = 0; i < size; i++) {
                Tweets.Sender sender = senderList.get(i);
                String userName = sender.getNick();
                int start = builder.length();
                int end = start + userName.length();
                builder.append(userName);
                if (i != size - 1) {
                    builder.append(", ");
                }
                builder.setSpan(new TextClickSpan(context, userName), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            builder.setSpan(new VerticalImageSpan(ContextCompat.getDrawable(context, R.drawable.heart_drawable_dark)),
                    0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            return builder;
        }

        return null;
    }

    /**
     * 评论数据格式转化
     *
     * @param commentsList
     * @return
     */
    public static List<CommentBean> getComments(Context context, List<Tweets.Comments> commentsList) {
        List<CommentBean> commentBeanList = new ArrayList<>();
        for (int i = 0; i < commentsList.size(); i++) {
            Tweets.Comments commenTweet = commentsList.get(i);
            CommentBean commentBean = new CommentBean();
            commentBean.setCommentType(Constants.CommentType.COMMENT_TYPE_SINGLE);
            commentBean.setCommentContent(commenTweet.getContent());
            commentBean.setCommentUser(commenTweet.getSender().getNick());
            commentBean.build(context);
            commentBeanList.add(commentBean);
        }
        return commentBeanList;
    }
}
