package com.ism.repositories.database;

import com.ism.entities.Article;
import com.ism.db.DatabaseConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MySQLArticleRepository {
    public void save(Article article) {
        EntityManager entityManager = DatabaseConnection.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(article);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
    @SuppressWarnings("unchecked") // Suppression de l'avertissement de type
    public List<Article> findAll() {
        EntityManager entityManager = DatabaseConnection.getEntityManager();
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        List<Article> articles = query.getResultList();
        entityManager.close();
        return articles;
    }
}
