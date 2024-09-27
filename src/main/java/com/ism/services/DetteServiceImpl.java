package com.ism.services;

import com.ism.entities.Dette;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DetteServiceImpl {

    private final EntityManager entityManager;

    public DetteServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addDette(Dette dette) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(dette);
        transaction.commit();
    }

    public List<Dette> listDettes() {
        return entityManager.createQuery("SELECT d FROM Dette d", Dette.class).getResultList();
    }
}
