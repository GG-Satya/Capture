package com.satya.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SqlTransaction {
	
	private static EntityManagerFactory emf;
	
	public static EntityTransaction beginTransaction() throws Exception {
	    EntityManager em = null;
	    EntityTransaction et = null;
	    
	    try {
	        em = getEntityManager();
	        et = em.getTransaction();
	        et.begin();
	    } catch(Exception e) {
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	        throw e;
	    }
	    
	    return et;
	}
	
	private static EntityManager getEntityManager() {
	    if (emf == null) {
	        emf = Persistence.createEntityManagerFactory("pu");
	    }
	    return emf.createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
	    if (emf != null && emf.isOpen()) {
	        emf.close();
	    }
	}
}
