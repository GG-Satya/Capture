<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.satya.entities.Note"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Taker : All Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="Navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">All notes</h1>
		<%
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT n FROM Note n");
		List<Note> notes = query.getResultList();
		for (Note note : notes) {
		%>
		<div class="card mt-4">
			<img class="card-img-top ml-4 mt-4" style="max-width: 50px;"
				src="images/notepad.png" alt="Card image cap">
			<div class="card-body p-2">
				<h5 class="card-title text-center"><%=note.getTitle()%></h5>
				<p><%=note.getContent()%></p>
				<p class="card-text text-primary date"><%=note.getAddedDate()%></p>
				<a href="edit_note.jsp?note_id=<%=note.getId()%>"
					class="btn btn-primary">Edit</a> <a
					href="DeleteNoteServlet?note_id=<%=note.getId()%>"
					method="POST"
					class="btn btn-danger">Delete</a>
			</div>
		</div>
		<%
		}
		em.close();
		emf.close();
		%>
	</div>
</body>
</html>