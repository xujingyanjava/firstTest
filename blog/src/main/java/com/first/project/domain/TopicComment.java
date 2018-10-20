package com.first.project.domain;

public class TopicComment extends DbCommon {

    private static final long serialVersionUID = 189021095546580973L;

    private Long topicId;

    private Long userId;

    private String commentContent;


    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
