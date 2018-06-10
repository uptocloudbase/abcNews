package org.agd.abcnews.controllers;

import org.agd.abcnews.entity.Article;
import org.agd.abcnews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EditPageController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/viewPage")
    public String viewPage(@RequestParam("id") String articleId, Map<String, Object> model) {


        model.put("article", articleService.getArticle(articleId));
        return "viewPage";

    }

    @RequestMapping("/editPage")
    public String editPage(@RequestParam("id") String articleId, Map<String, Object> model) {


        model.put("article", articleService.getArticle(articleId));
        return "editPage";

    }


}