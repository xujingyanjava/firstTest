package com.first.project.domain;


import javax.persistence.*;

@Entity
@Table(name = "topic_main")
public class Topic extends DbCommon{

    private static final long serialVersionUID = 4800615921476597884L;

    @Column(name = "topic_name",length = 50)
    private String topicName;

    @Column(name = "author",length = 50)
    private String author;

    @Column(name = "view_time")
    private Integer viewTime = 0;

    @Column(name = "click_time")
    private Integer clickTime = 0;

    @Column(name = "cover_img",length = 100)
    private String coverImg;

    @Column(name = "content",length = 1000)
    private String content;

    @Column(name = "title",length = 20)
    private String title;

    @Column(name = "is_top")
    private Integer isTop = 0;

    @Column(name = "is_excellent")
    private Integer isExcellent = 0;

    @Column(name = "two_title",length = 50)
    private String twoTitle;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getViewTime() {
        return viewTime;
    }

    public void setViewTime(Integer viewTime) {
        this.viewTime = viewTime;
    }

    public Integer getClickTime() {
        return clickTime;
    }

    public void setClickTime(Integer clickTime) {
        this.clickTime = clickTime;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsExcellent() {
        return isExcellent;
    }

    public void setIsExcellent(Integer isExcellent) {
        this.isExcellent = isExcellent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTwoTitle() {
        return twoTitle;
    }

    public void setTwoTitle(String twoTitle) {
        this.twoTitle = twoTitle;
    }
}
