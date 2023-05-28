<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="Navbar.jsp"%>
		<!--   	Form -->
		<h2>Welcome! to note taker app</h2>
		<form action="SaveNoteServlet" method="post">
			<div class="form-group ">
				<label for="exampleInputEmail1">Title</label> <input name="title"
					type="text" class="form-control" id="title"
					placeholder="Enter Title"> <small id="emailHelp"
					class="form-text text-muted">Enter the title of your
					content</small>
			</div>
			<div class="form-group">
				<label for="title">Note Content</label>
				<textarea name="content" required="true" class="form-control"
					placeholder="Start writing from here..." style="height: 300px;"></textarea>
			</div>
			<button type="submit" class="btn btn-primary mx-auto d-block" >Submit</button>
		</form>
<!-- 		<div id="popup-card"> -->
<!-- 			<div class="card"> -->
<!-- 				<h2>Note Saved Successfully</h2> -->
<!-- 				<p>Your note has been saved.</p> -->
<!-- 				<button onclick="hidePopup()">Close</button> -->
<!-- 			</div> -->
<!-- 		</div> -->

	</div>
</body>
</html>