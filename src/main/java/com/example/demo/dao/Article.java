package com.example.demo.dao;

import javax.validation.constraints.NotNull;

import java.util.Date;

public class Article {
    public Integer id;
    @NotNull(message="author should not be null")
    public String author;
    public Date updateDate;
    public Date writtenDate;
    @NotNull(message="content should not be null")
    public String content;
    @NotNull(message="title should not be null")
    public String title;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setWrittenDate(Date writtenDate) {
        this.writtenDate = writtenDate;
    }

    public Date getWrittenDate() {
        return this.writtenDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
