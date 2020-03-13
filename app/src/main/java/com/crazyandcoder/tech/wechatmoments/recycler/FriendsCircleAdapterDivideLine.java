package com.crazyandcoder.tech.wechatmoments.recycler;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.crazyandcoder.tech.wechatmoments.utils.Utils;

/**
 * @ClassName: FriendsCircleAdapterDivideLine
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 4:32 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 4:32 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FriendsCircleAdapterDivideLine extends RecyclerView.ItemDecoration {
    private int mDivideHeight;

    public FriendsCircleAdapterDivideLine() {
        mDivideHeight = Utils.dp2px(0.5f);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, mDivideHeight);
    }
}
