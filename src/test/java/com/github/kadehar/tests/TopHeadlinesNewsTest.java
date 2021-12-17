package com.github.kadehar.tests;

import com.github.kadehar.data.api.NewsInteractor;
import com.github.kadehar.data.api.model.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopHeadlinesNewsTest {
    @Test
    public void userCanFetchTopHeadlinesNewsByCountyCode() {
        String countryCode = "ru";

        News news = NewsInteractor.fetchNews(countryCode);

        Assertions.assertTrue(news.articles.size() > 0);
    }

    @Test
    public void userCanFetchTopHeadlinesNewsByCountyCodeUsingEither() {
        String countryCode = "us";

        News news = NewsInteractor.fetchNewsWithEither(countryCode).get();

        Assertions.assertTrue(news.articles.size() > 0);
    }
}
