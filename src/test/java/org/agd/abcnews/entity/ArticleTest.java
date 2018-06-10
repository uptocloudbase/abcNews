package org.agd.abcnews.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleTest {

    @Test
    public void testJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Article a = new Article();
        a.setPublishDate(new Date());
        a.setStatus(PublishStatus.PUBLISHED);
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("This is great!", new Date(), "user1", PublishStatus.PUBLISHED));
        a.setComments(comments);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a));

        User u = new User();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(u));
    }
}