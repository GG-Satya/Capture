<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Note Taker : Home page</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="Navbar.jsp"%>
		<div class="card py-5">
			<img class="img-fluid mx-auto" alt="" src="images/notepad.png"
				style="max-width: 400px">
			<h1 class="text-primary text-center text-uppercase">Start Taking your Notes</h1>
			<div class="container text-center">
				<button class="btn btn-outline-primary" onclick="window.location.href='add_notes.jsp';">Strat Here</button>
			</div>
		</div>
	</div>
</body>
</html>