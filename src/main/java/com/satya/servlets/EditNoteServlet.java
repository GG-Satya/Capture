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

public class EditNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		PrintWriter out = null;
		
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int id = Integer.parseInt(request.getParameter("noteId").trim());
			
			response.setContentType("text/html");
			out = response.getWriter();
			if (content.length() >= 1500) {
				System.out.println(content.length());
				response.setContentType("text/html");
				out = response.getWriter();
				out.println("<h1 style='text-align: center;'>Error: Note is too long  i.e </h1>");
				out.println("<h1 style='text-align: center;'><a href='add_notes.jsp'/>Create new note</h1>");
			}
			
			
			emf = Persistence.createEntityManagerFactory("pu");
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			et.begin();
			
			Note note = em.find(Note.class, id);
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			em.persist(note);
			
			et.commit();
			response.sendRedirect("all_notes.jsp");
			
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
            if(out != null) {
            	out.close();
            }
        }
	}
}

