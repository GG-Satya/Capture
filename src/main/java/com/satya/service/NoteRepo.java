package com.satya.service;

import com.satya.entities.Note;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class NoteRepo {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static boolean save(Note note) {
        EntityTransaction et = null;
        boolean saved = false;

        try {
            emf = Persistence.createEntityManagerFactory("pu");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(note);
            et.commit();
            saved = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
        return saved;
    }
}
