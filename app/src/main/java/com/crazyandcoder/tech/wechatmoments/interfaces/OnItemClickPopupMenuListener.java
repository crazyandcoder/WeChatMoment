package com.crazyandcoder.tech.wechatmoments.interfaces;

/**
 * @ClassName: OnItemClickPopupMenuListener
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/12 4:10 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 4:10 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OnItemClickPopupMenuListener {
    void onItemClickCopy(int position);

    void onItemClickTranslation(int position);

    void onItemClickHideTranslation(int position);

    void onItemClickCollection(int position);
}
