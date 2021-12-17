package com.github.kadehar.data.api;

import com.github.kadehar.data.api.model.News;
import com.github.kadehar.network.RetrofitClient;
import io.vavr.control.Either;

import java.io.IOException;

public class NewsInteractor {
    public static Either<String, News> fetchNewsWithEither(String country) {
        NewsApi api = RetrofitClient.createService(NewsApi.class);
        try {
            return Either.right(api.fetchNews(country).execute().body());
        } catch (IOException ioEx) {
            return Either.left("Unable to fetch news!");
        }
    }

    public static News fetchNews(String country) {
        NewsApi api = RetrofitClient.createService(NewsApi.class);
        try {
            return api.fetchNews(country).execute().body();
        } catch (IOException e) {
            return new News();
        }
    }
}
