package org.agd.abcnews.dao;

import org.agd.abcnews.entity.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

public class DBHandlerTest {

    private DBHandler target;

    @Before
    public void setup() {
        target = new DBHandler("51.145.133.0", "abcnews");
    }

    @Test
    public void listArticles() {

        List<Article> result = target.listArticles(false);

        assertEquals(2, result.size());

        result = target.listArticles(true);

        assertEquals(4, result.size());

        assertNotNull(result.get(0).getId());
    }

    @Test
    public void getArticle() {
        Article result = target.getArticle("5b1a8e14db74ae9d2331cd85");

        assertEquals("Test Article 2", result.getTitle());
    }

    @Test
    public void getUser() {
        fail("Not yet implemented.");
    }
}