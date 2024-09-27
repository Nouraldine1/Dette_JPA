package com.ism.services;

import com.ism.entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientServiceImpl {

    private final EntityManager entityManager;

    public ClientServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addClient(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    public List<Client> listClients() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}
