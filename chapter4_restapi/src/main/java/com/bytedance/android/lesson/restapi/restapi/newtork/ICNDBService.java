package com.bytedance.android.lesson.restapi.restapi.newtork;

import com.bytedance.android.lesson.restapi.restapi.bean.Joke;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Xavier.S
 * @date 2019.01.15 16:42
 */
public interface ICNDBService {
    @GET("jokes/random") Call<Joke> randomJoke();
}
