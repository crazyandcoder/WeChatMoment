package com.crazyandcoder.tech.wechatmoments.mvp.base;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: BasePresenter
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 5:35 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 5:35 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private WeakReference<V> mWeakReferenceView;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(@NonNull V view) {
        mWeakReferenceView = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mWeakReferenceView != null) {
            mWeakReferenceView.clear();
            mWeakReferenceView = null;
        }
        onUnSubscribe();

    }

    @Override
    public V getAttachedView() {
        final V view = mWeakReferenceView == null ? null : mWeakReferenceView.get();
        if (view != null) {
            return view;
        } else {
            throw new IllegalStateException(
                    "No View attached to Presenter. Presenter destroyed = ");
        }
    }

    public void addSubscription(Observable observable, DisposableObserver disposableObserver) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposableObserver);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(disposableObserver);
    }

    public void onUnSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable = null;
        }
    }

}
