package com.saint.struct.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava2.PagingRx;

import com.saint.struct.bean.WanListBean;
import com.saint.struct.data.Paging3RxDataResource;
import com.saint.struct.network.HttpManager;

import io.reactivex.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class Paging3RxViewModel extends ViewModel {
    Pager<Integer, WanListBean> mPager;
    Paging3RxDataResource mPaging3RxDataResource;

    //rxjava flowable
    Flowable<PagingData<WanListBean>> flowable;

    public Paging3RxViewModel(Context context) {
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        /**
         * 数据源
         */
        mPaging3RxDataResource = new Paging3RxDataResource(HttpManager.getInstance().getService());
        /**
         * Pager ：分页大管家, 使用网络数据源构造
         */
        PagingConfig config = new PagingConfig(20);
        mPager = new Pager<Integer, WanListBean>(config, () -> mPaging3RxDataResource);

        /**
         *  PagingRx.getObservable
         */
        flowable = PagingRx.getFlowable(mPager);
        PagingRx.cachedIn(flowable, viewModelScope);
    }

    public Flowable<PagingData<WanListBean>> getFlowable() {
        return flowable;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Application mApplication;

        public Factory(@NonNull Application application) {
            mApplication = application;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new Paging3RxViewModel(mApplication);
        }
    }
}
