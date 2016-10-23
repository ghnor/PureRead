package com.ghnor.pureread.util;

import com.ghnor.pureread.api.GankApis;
import com.ghnor.pureread.config.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ghnor on 2016/10/23.
 */

public class ServiceRequester {

    public static GankApis getGankAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.GANK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(GankApis.class);
    }


}
