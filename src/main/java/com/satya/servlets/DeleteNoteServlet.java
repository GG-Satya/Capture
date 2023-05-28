package com.satya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.satya.entities.Note;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeleteNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			int id = Integer.parseInt(request.getParameter("note_id").trim());
			
			
			
			emf = Persistence.createEntityManagerFactory("pu");
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			Note note = em.find(Note.class, id);
			
			em.remove(note);
			
			et.commit();
			
			
		}catch(Exception e) {
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
		response.sendRedirect("all_notes.jsp");
	}

}
