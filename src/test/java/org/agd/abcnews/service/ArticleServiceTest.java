package org.agd.abcnews.service;

import org.agd.abcnews.dao.DBHandler;
import org.agd.abcnews.entity.Article;
import org.agd.abcnews.entity.ArticleSummary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.*;

public class ArticleServiceTest {

    @Test
    public void listArticles() {

        DBHandler dbHandler = mock(DBHandler.class);
        List<Article> articles = createTestArticles();
        when (dbHandler.listArticles(anyBoolean()))
        .thenReturn(articles);

        ArticleService target = new ArticleService(dbHandler);

        List<ArticleSummary> result = target.listArticles(true);

        assertEquals(4, result.size());

        assertEquals("abc123", result.get(0).getId());
        assertEquals("Test1", result.get(0).getTitle());
        assertEquals(3, result.get(0).getNumLikes());
    }

    private List<Article> createTestArticles() {

        List<Article> articles = new ArrayList<>();
        articles.add(createArticle("abc123", "Test1", Arrays.asList(new String[] {"", "", ""})));
        articles.add(createArticle("abc124", "Test2", Arrays.asList(new String[] {""})));
        articles.add(createArticle("abc125", "Test3", Arrays.asList(new String[] {})));
        articles.add(createArticle("abc126", "Test4", Arrays.asList(new String[] {"", ""})));

        return articles;

    }

    private Article createArticle(String id, String title, List<String> likes) {

        Article a = new Article();
        a.setId(id);
        a.setTitle(title);
        a.setLikes(likes);

        return a;
    }
}