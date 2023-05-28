<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="com.satya.entities.Note"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Taker: Edit Note</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="Navbar.jsp"%>
		<h1>Edit Note:</h1>
		<%
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		Note note = em.find(Note.class, noteId);
		%>
		<form action="EditNoteServlet" method="post">
			<input value="<%=note.getId()%>" name="noteId" hidden="true">
			<div class="form-group ">
				<label for="exampleInputEmail1">Title</label> <input name="title"
					type="text" class="form-control" id="title"
					placeholder="Enter Title" value="<%=note.getTitle()%>"> <small
					id="emailHelp" class="form-text text-muted">Enter the title
					of your content</small>
			</div>
			<div class="form-group">
				<label for="title">Note Content</label>
				<textarea name="content" required="true" class="form-control"
					placeholder="Start writing from here..." style="height: 300px;"><%=note.getContent()%></textarea>
			</div>
			<button type="submit" class="btn btn-success">Save Changes</button>
		</form>
	</div>
</body>
</html>