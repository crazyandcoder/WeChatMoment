package com.crazyandcoder.tech.wechatmoments.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.crazyandcoder.tech.wechatmoments.R;
import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.config.Constants;
import com.crazyandcoder.tech.wechatmoments.interfaces.OnPraiseOrCommentClickListener;
import com.crazyandcoder.tech.wechatmoments.utils.DataUtils;
import com.crazyandcoder.tech.wechatmoments.utils.Utils;
import com.crazyandcoder.tech.wechatmoments.widget.CommentCustomeWidget;
import com.crazyandcoder.tech.wechatmoments.widget.CommentOrPraisePopupWindow;
import com.crazyandcoder.tech.wechatmoments.widget.NineGridView;

import java.util.ArrayList;
import java.util.List;

import ch.ielse.view.imagewatcher.ImageWatcher;

/**
 * @ClassName: FriendCircleAdapter
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 4:33 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 4:33 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FriendCircleAdapter extends RecyclerView.Adapter<FriendCircleAdapter.FriendCircleViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Tweets> mDataList;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private ImageWatcher mImageWatcher;
    private RequestOptions mRequestOptions;
    private int mAvatarSize;
    private DrawableTransitionOptions mDrawableTransitionOptions;
    private CommentOrPraisePopupWindow mCommentOrPraisePopupWindow;

    public FriendCircleAdapter(Context mContext, RecyclerView mRecyclerView, ImageWatcher mImageWatcher) {
        this.mContext = mContext;
        this.mRecyclerView = mRecyclerView;
        this.mImageWatcher = mImageWatcher;
        this.mLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        this.mAvatarSize = Utils.dp2px(44f);
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mRequestOptions = new RequestOptions().centerCrop();
        this.mDrawableTransitionOptions = DrawableTransitionOptions.withCrossFade();

    }

    /**
     * 设置数据源
     *
     * @param mDataList
     */
    public void setFriendCircleData(List<Tweets> mDataList) {
        if (this.mDataList != null && !this.mDataList.isEmpty())
            this.mDataList.clear();
        this.mDataList = mDataList;
        notifyDataSetChanged();
    }


    /**
     * 插入数据
     *
     * @param mDataList
     */
    public void addFriendCircleData(List<Tweets> mDataList) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList<>();
        }
        this.mDataList.addAll(mDataList);
        notifyItemRangeInserted(this.mDataList.size(), mDataList.size());
    }

    @NonNull
    @Override
    public FriendCircleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendCircleViewHolder(mLayoutInflater.inflate(R.layout.item_recycler_firend_circle_word_and_images, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FriendCircleViewHolder holder, int position) {
        if (holder != null && mDataList != null && position < mDataList.size()) {
            Tweets tweet = mDataList.get(position);

            //post内容
            if (!TextUtils.isEmpty(tweet.getContent())) {
                holder.txtContent.setVisibility(View.VISIBLE);
                holder.txtContent.setText("" + tweet.getContent());
            } else {
                holder.txtContent.setVisibility(View.GONE);
            }


            //用户信息
            Tweets.Sender sender = tweet.getSender();
            if (sender != null) {
                holder.txtUserName.setText("" + sender.getNick());
                Glide.with(mContext).load(sender.getAvatar())
                        .apply(mRequestOptions.override(mAvatarSize, mAvatarSize))
                        .transition(mDrawableTransitionOptions)
                        .into(holder.imgAvatar);
            }

            //九宫图
            List<Tweets.Images> imagesList = tweet.getImages();
            if (imagesList != null && imagesList.size() > 0) {
                List<String> imgUrl = new ArrayList<>();
                for (Tweets.Images image : imagesList) {
                    imgUrl.add(image.getUrl());
                }
                holder.nineGridView.setAdapter(new NineImageAdapter(mContext, mRequestOptions,
                        mDrawableTransitionOptions, imgUrl));
                holder.nineGridView.setOnImageClickListener((position1, view) ->
                        mImageWatcher.show((ImageView) view, holder.nineGridView.getImageViews(),
                                imgUrl));
            }

            //发布时间
            holder.txtPublishTime.setText("昨天");

            //评论
            List<Tweets.Comments> commentsList = tweet.getComments();
            if (commentsList != null && commentsList.size() > 0) {
                holder.layoutPraiseAndComment.setVisibility(View.VISIBLE);
                holder.imgPraiseOrComment.setVisibility(View.GONE);
                //设置点赞的人
                holder.txtPraiseContent.setText(DataUtils.getPraisePeople(mContext, commentsList));
                holder.commentCustomeWidget.addComments(DataUtils.getComments(mContext, commentsList), false);

            } else {
                holder.layoutPraiseAndComment.setVisibility(View.GONE);
                holder.imgPraiseOrComment.setVisibility(View.GONE);
            }


        }
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static class FriendCircleViewHolder extends RecyclerView.ViewHolder {
        public TextView txtUserName;
        public View viewLine;
        public TextView txtPraiseContent;
        public ImageView imgAvatar;
        public TextView txtSource;
        public TextView txtPublishTime;
        public ImageView imgPraiseOrComment;
        public TextView txtLocation;
        public TextView txtContent;
        public TextView txtState;
        public LinearLayout layoutPraiseAndComment;
        public NineGridView nineGridView;
        public CommentCustomeWidget commentCustomeWidget;

        public FriendCircleViewHolder(@NonNull View itemView) {
            super(itemView);
            commentCustomeWidget = itemView.findViewById(R.id.comment_widget);
            nineGridView = itemView.findViewById(R.id.nine_grid_view);
            txtUserName = itemView.findViewById(R.id.txt_user_name);
            txtPraiseContent = itemView.findViewById(R.id.praise_content);
            viewLine = itemView.findViewById(R.id.view_line);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            txtSource = itemView.findViewById(R.id.txt_source);
            txtPublishTime = itemView.findViewById(R.id.txt_publish_time);
            imgPraiseOrComment = itemView.findViewById(R.id.img_click_praise_or_comment);
            txtLocation = itemView.findViewById(R.id.txt_location);
            txtContent = itemView.findViewById(R.id.txt_content);
            txtState = itemView.findViewById(R.id.txt_state);
            layoutPraiseAndComment = itemView.findViewById(R.id.layout_praise_and_comment);
        }
    }
}
