<%@page import="bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Article> articles = (List<Article>) request.getAttribute("articles");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Imports css -->
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<title>Tuto</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row">
			<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
				<div class="container-fluid">
					<a class="navbar-brand" href="#">Blog dev</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarColor01"
						aria-controls="navbarColor01" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarColor01">
						<ul class="navbar-nav me-auto">
							<li class="nav-item"><a class="nav-link active" href="#">Accueil
									<span class="visually-hidden">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="tuto">Tutos</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">Contact</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#">A
									propos</a></li>
						</ul>
						<form class="d-flex">
							<input class="form-control me-sm-2" type="search"
								placeholder="Search">
							<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
						</form>
					</div>
				</div>
			</nav>
		</header>
		<main class="row mt-5">
			<div class="row text-center">
				<h1>Tuto</h1>
			</div>
			<div class="col-8 offset-2 mt-2">
				<div class="row mt-5">
					<!-- Code Java -->
					<%int cpt = 0;%>
					<%for (Article article : articles) {%>
					<%if (cpt!=0 && cpt%3==0){ %>
					<div class="row"></div>
					<%}%>
					<div class="col">
						<div class="card text-white bg-primary mb-3"
							style="max-width: 20rem;">
							<div class="card-header"><%=article.getAuthor()%></div>
							<div class="card-body">
								<h4 class="card-title"><%=article.getTitle()%></h4>
								<p class="card-text"><%=article.getContent()%></p>
							</div>
						</div>
					</div>
					<% cpt++;%>
					<% } %>
				</div>

			</div>
		</main>
		<footer class="row text-center">
			<p>
				<small>Blog Dev &copy; 2023</small>
			</p>
		</footer>
</body>
</html>