package com.example.demo.service;

import com.example.demo.dao.Article;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public Article getArticle(Integer id) {
        return this.articleMapper.getArticle(id);
    }

    public void deleteArticle(Integer id) {
        this.articleMapper.deleteArticle(id);
    }

    public List<Article> getArticles() {
        return this.articleMapper.getArticles();
    }

    public void updateArticle(Article article) { this.articleMapper.updateArticle(article); }

    public void createArticle(Article article) { this.articleMapper.createArticle(article); }

}
