package com.github.kadehar.data.api;

import com.github.kadehar.base.Constants;
import com.github.kadehar.data.api.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET(Constants.TOP_HEADLINES_ENDPOINT)
    Call<News> fetchNews(@Query("country") String country);
}
