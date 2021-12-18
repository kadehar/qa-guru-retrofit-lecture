package com.github.kadehar.tests;

import com.github.kadehar.data.api.NewsInteractor;
import com.github.kadehar.data.api.model.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EverythingTest {
    @Test
    public void userCanFoundAnyArticlesAboutFootball() {
        String title = "football";

        News news = NewsInteractor.fetchNewsByTitle(title).get();

        news.articles.forEach(article ->
                Assertions.assertTrue(article.title.contains(title))
        );

        Assertions.assertTrue(news.articles.size() > 0);
    }

    @Test
    public void userCanSeeError() {
        String title = "football";

        String error = NewsInteractor.fetchNewsByTitle(title).getLeft();

        Assertions.assertTrue(error != "");
    }

}
