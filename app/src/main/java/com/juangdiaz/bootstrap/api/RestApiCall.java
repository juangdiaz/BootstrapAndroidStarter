package com.juangdiaz.bootstrap.api;

import com.juangdiaz.bootstrap.model.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
public class RestApiCall {

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostsList();
    }
}
