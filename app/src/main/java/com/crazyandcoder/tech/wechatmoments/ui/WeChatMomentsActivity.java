package com.crazyandcoder.tech.wechatmoments.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crazyandcoder.tech.wechatmoments.R;
import com.crazyandcoder.tech.wechatmoments.adapter.FriendCircleAdapter;
import com.crazyandcoder.tech.wechatmoments.bean.Tweets;
import com.crazyandcoder.tech.wechatmoments.bean.UserInfo;
import com.crazyandcoder.tech.wechatmoments.interfaces.OnPraiseOrCommentClickListener;
import com.crazyandcoder.tech.wechatmoments.mvp.presenter.WeChatMomentsActivityPresenter;
import com.crazyandcoder.tech.wechatmoments.mvp.view.WeChatMomentsActivityView;
import com.crazyandcoder.tech.wechatmoments.recycler.FriendsCircleAdapterDivideLine;
import com.crazyandcoder.tech.wechatmoments.recycler.GlideSimpleTarget;
import com.crazyandcoder.tech.wechatmoments.utils.Utils;
import com.crazyandcoder.tech.wechatmoments.widget.swipefresh.CustomProgressDrawable;
import com.crazyandcoder.tech.wechatmoments.widget.swipefresh.CustomSwipeRefreshLayout;

import java.util.List;

import ch.ielse.view.imagewatcher.ImageWatcher;

/**
 * jsmith
 */
public class WeChatMomentsActivity extends MvpActivity<WeChatMomentsActivityView, WeChatMomentsActivityPresenter> implements WeChatMomentsActivityView, ImageWatcher.OnPictureLongPressListener, ImageWatcher.Loader {

    private TextView mUserNameTv;
    private ImageView mWeChatBackgroundImg;
    private ImageView mUserIconImg;
    private RecyclerView mFriendsRecyclerView;
    private CustomSwipeRefreshLayout mRefreshView;
    private ImageWatcher mImageWatcher;
    private FriendCircleAdapter mFriendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat_moments);

        mUserNameTv = (TextView) findViewById(R.id.username_tv);
        mUserIconImg = (ImageView) findViewById(R.id.usericon_img);
        mWeChatBackgroundImg = (ImageView) findViewById(R.id.wechat_background_img);
        mFriendsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRefreshView = (CustomSwipeRefreshLayout) findViewById(R.id.swpie_refresh_layout);
        mImageWatcher = (ImageWatcher) findViewById(R.id.image_watcher);

        mFriendsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFriendsRecyclerView.addItemDecoration(new FriendsCircleAdapterDivideLine());
        mFriendAdapter = new FriendCircleAdapter(this, mFriendsRecyclerView, mImageWatcher);
        mFriendsRecyclerView.setAdapter(mFriendAdapter);

        mImageWatcher.setTranslucentStatus(Utils.calcStatusBarHeight(this));
        mImageWatcher.setErrorImageRes(R.mipmap.error_picture);
        mImageWatcher.setOnPictureLongPressListener(this);
        mImageWatcher.setLoader(this);

        initSwipeRefresh();


    }

    private void initSwipeRefresh() {
        CustomProgressDrawable drawable = new CustomProgressDrawable(this, mRefreshView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moments_refresh_icon);
        drawable.setBitmap(bitmap);
        mRefreshView.setProgressView(drawable);
        mRefreshView.setBackgroundColor(Color.BLACK);
        mRefreshView.setProgressBackgroundColorSchemeColor(Color.BLACK);
        mRefreshView.setOnRefreshListener(new CustomSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getTweets("jsmith");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getUserInfo("jsmith");
        presenter.getTweets("jsmith");
    }

    @NonNull
    @Override
    public WeChatMomentsActivityPresenter createPresenter() {
        return new WeChatMomentsActivityPresenter(dataManager);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        if (!TextUtils.isEmpty(userInfo.getAvatar()))
            Glide.with(this).load(userInfo.getAvatar()).into(mUserIconImg);
        if (!TextUtils.isEmpty(userInfo.getProfileImage()))
            Glide.with(this).load(userInfo.getProfileImage()).into(mWeChatBackgroundImg);
        mUserNameTv.setText(userInfo.getNick());

    }

    @Override
    public void updateTweets(List<Tweets> tweetsList) {
        mRefreshView.setRefreshing(false);
        mFriendAdapter.setFriendCircleData(tweetsList);
    }

    @Override
    public void onFailure(String msg) {
        mRefreshView.setRefreshing(false);
    }


    @Override
    public void load(Context context, String url, ImageWatcher.LoadCallback lc) {
        Glide.with(context).asBitmap().load(url).into(new GlideSimpleTarget(lc));
    }

    @Override
    public void onPictureLongPress(ImageView v, String url, int pos) {

    }

}
