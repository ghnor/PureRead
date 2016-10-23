package com.ghnor.pureread.api;

import com.ghnor.pureread.entity.BaseEntity;
import com.ghnor.pureread.entity.GankEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ghnor on 2016/10/23.
 */

public interface GankApis {

    public static final String GANK_BASE_URL = "http://gank.io/api/";

    /**
     * 技术文章列表
     * @param type
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @GET("data/{type}/{pageSize}/{pageIndex}")
    Observable<BaseEntity<List<GankEntity>>> getGankTechList(
            @Path("type") String type,
            @Path("pageSize") int pageSize,
            @Path("pageIndex") int pageIndex);

    /**
     * 妹纸列表
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @GET("data/福利/{pageSize}/{pageIndex}")
    Observable<BaseEntity<List<GankEntity>>> getGankGirlList(
            @Path("pageSize") int pageSize,
            @Path("pageIndex") int pageIndex);
}
