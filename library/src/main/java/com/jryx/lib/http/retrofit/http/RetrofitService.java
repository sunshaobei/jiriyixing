package com.jryx.lib.http.retrofit.http;


import com.jryx.lib.http.ok3.entity.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;


/**
 * Created by sunsh on 2018/5/29.
 */

public interface RetrofitService {

    @GET("{url}")
    Observable<HttpResponse> executeGet(
            @Path("url") String url,
            @QueryMap Map<String, String> maps
    );


    @POST("{url}")
    Observable<HttpResponse> executePost(
            @Path("url") String url,
            //  @Header("") String authorization,
            @QueryMap Map<String, String> maps);

    @POST("{url}")
    Observable<HttpResponse> json(
            @Path("url") String url,
            @Body RequestBody jsonStr);

    @Multipart
    @POST("{url}")
    Observable<HttpResponse> upLoadFile(
            @Path("url") String url,
            @Part("image\"; filename=\"image.jpg") RequestBody requestBody);

    @POST("{url}")
    Call<HttpResponse> uploadFiles(
            @Path("url") String url,
            @Path("headers") Map<String, String> headers,
            @Part("filename") String description,
            @PartMap() Map<String, RequestBody> maps);

    @Streaming
    @GET
    Observable<HttpResponse> downloadFile(@Url String fileUrl);

    @GET("{url}")
    Observable<HttpResponse> get(@Path("url") String url, @Body RequestBody requestBody);
}
