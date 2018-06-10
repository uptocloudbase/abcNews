package org.agd.abcnews.entity;

import java.util.Date;

public class Comment {

	private String comment;
	private Date commentDate;
	private String userId;
	private PublishStatus publishStatus;

	public Comment() {}

    public Comment(String comment, Date commentDate, String userId, PublishStatus publishStatus) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.userId = userId;
        this.publishStatus = publishStatus;
    }

    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PublishStatus getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(PublishStatus publishStatus) {
		this.publishStatus = publishStatus;
	}
}