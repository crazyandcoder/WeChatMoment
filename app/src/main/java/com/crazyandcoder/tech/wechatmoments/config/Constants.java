package com.crazyandcoder.tech.wechatmoments.config;

/**
 * @ClassName: Constants
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 4:47 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 4:47 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Constants {

    public final static class FriendCircleType {
        //纯文字
        public final static int FRIEND_CIRCLE_TYPE_ONLY_WORD = 0;
        //文字和图片
        public final static int FRIEND_CIRCLE_TYPE_WORD_AND_IMAGES = 1;
        //分享链接
        public final static int FRIEND_CIRCLE_TYPE_WORD_AND_URL = 2;
    }

    public final static class CommentType {
        //单一评论
        public final static int COMMENT_TYPE_SINGLE = 0;
        //回复评论
        public final static int COMMENT_TYPE_REPLY = 1;
    }

}
