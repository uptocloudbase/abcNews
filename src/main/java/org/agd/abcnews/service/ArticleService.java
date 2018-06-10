package org.agd.abcnews.service;
import org.agd.abcnews.dao.DBHandler;
import org.agd.abcnews.entity.Article;
import org.agd.abcnews.entity.ArticleSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleService {

    @Autowired
    private final DBHandler dbHandler;

    public ArticleService(DBHandler dbHandler) {
	    this.dbHandler = dbHandler;
    }


	/**
	 * 
	 * @param article
	 */
	public void createArticle(Article article){

		//TODO: Not yet implemented

	}

	/**
	 * 
	 * @param articleId
	 */
	public boolean deleteArticle(int articleId){

		//TODO: Not yet implemented
		return false;
	}

	/**
	 * 
	 * @param articleId
	 */
	public Article getArticle(String articleId){
		return dbHandler.getArticle(articleId);
	}

	/**
	 * 
	 * @param includeNonPublished
	 */
	public List<ArticleSummary> listArticles(boolean includeNonPublished){

		List<ArticleSummary> summaries = new ArrayList<>();

		//TODO:  Need to deal with data paging
		List<Article> rawArticles = dbHandler.listArticles(includeNonPublished);

		rawArticles.forEach(a -> {
			summaries.add(new ArticleSummary(a.getId(), a.getPublishDate(), a.getStatus(), a.getTitle(), a.getLikes().size()));
		});


		return summaries;
	}

	/**
	 * 
	 * @param article
	 */
	public void updateArticle(Article article){
		//TODO: Not yet implemented
	}

}