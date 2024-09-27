package com.ism.repositories.database;

import com.ism.entities.Dette;
import com.ism.db.DatabaseConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MySQLDetteRepository {
    public void save(Dette dette) {
        EntityManager entityManager = DatabaseConnection.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(dette);
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
    public List<Dette> findAll() {
        EntityManager entityManager = DatabaseConnection.getEntityManager();
        Query query = entityManager.createQuery("SELECT d FROM Dette d");
        List<Dette> dettes = query.getResultList();
        entityManager.close();
        return dettes;
    }
}
