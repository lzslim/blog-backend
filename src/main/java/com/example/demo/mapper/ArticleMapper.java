package com.example.demo.mapper;

import com.example.demo.dao.Article;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleMapper {
    public Article getArticle(int id);

    public List<Article> getArticles();

    public void deleteArticle(int id);

    public void updateArticle(Article article);

    public void createArticle(Article article);
}
