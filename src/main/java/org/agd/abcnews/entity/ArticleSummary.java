package org.agd.abcnews.entity;

import java.util.Date;

public class ArticleSummary {

	private final String id;
	private final Date publishDate;
	private final PublishStatus publishStatus;
	private final String title;
	private final int numLikes;

	public ArticleSummary(String id, Date publishDate, PublishStatus publishStatus, String title, int numLikes) {
		this.id = id;
		this.publishDate = publishDate;
		this.publishStatus = publishStatus;
		this.title = title;
		this.numLikes = numLikes;
	}

	public String getId() {
		return id;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public PublishStatus getPublishStatus() {
		return publishStatus;
	}

	public String getTitle() {
		return title;
	}

	public int getNumLikes() {
		return numLikes;
	}
}