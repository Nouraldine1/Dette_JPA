package com.ism.services;

import com.ism.entities.Article;
import com.ism.repositories.database.MySQLArticleRepository;

import java.util.List;

public class ArticleServiceImpl {
    private final MySQLArticleRepository articleRepository;

    public ArticleServiceImpl() {
        this.articleRepository = new MySQLArticleRepository();
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    public List<Article> listArticles() {
        return articleRepository.findAll();
    }
}
