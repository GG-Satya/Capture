package com.satya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.satya.entities.Note;
import com.satya.service.NoteRepo;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrintWriter out;

	public SaveNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			Note note = new Note(title, content, new Date());

			// System.out.println(note.getId()+"--"+note.getTitle());

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (content.length() >= 1500) {
				System.out.println(content.length());
				response.setContentType("text/html");
				out = response.getWriter();
				out.println("<h1 style='text-align: center;'>Error: Note is too long  i.e </h1>");
				out.println("<h1 style='text-align: center;'><a href='add_notes.jsp'/>Create new note</h1>");
			}
			if (NoteRepo.save(note)) {
				out.println("<h1 style='text-align: center;'>Note Saved Successfully</h1>");
				out.println("<h1 style='text-align: center;'><a href='all_notes.jsp'/>view all notes</h1>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

}
