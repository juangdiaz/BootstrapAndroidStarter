package com.juangdiaz.bootstrap.api;

import com.juangdiaz.bootstrap.model.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author juandiaz <juandiaz@us.univision.com> Android Developer
 *         Copyright (C) 2016, Univision Communications Inc.
 */
public class RestApiCall {

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostsList();
    }
}
