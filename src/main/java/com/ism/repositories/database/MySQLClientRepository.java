package com.ism.repositories.database;

import com.ism.entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MySQLClientRepository {

    private final EntityManager entityManager;

    public MySQLClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked") // Suppression de l'avertissement de type
    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Client c");
        return query.getResultList(); // Type non vérifié ici
    }
}
