<%@page import="bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Article> articles = (List<Article>) request.getAttribute("articles"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- Imports css -->
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/style.css">
	<!-- fin import css -->
	<title>Tutos</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row" >
			<%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
		</header>
		
		<main class="row mt-5">
			<div class="row text-center">
				<h1>Tutos</h1>
			</div>
			<div class="col-8 offset-2">	
				<div class="row mt-5">
					<!-- Code Java -->
					
					<% for( Article article: articles ){ %>
					
							<div class="col-4">
								<div class="card text-white bg-info mb-3" style="max-width: 20rem;">
								  <div class="card-header"><%= article.getAuthor() %></div>
								  <div class="card-body">
								    <h4 class="card-title"><%= article.getTitle() %></h4>
								    <p class="card-text"><%= article.getContent() %></p>
								    <a href="<%=request.getContextPath() %>/tutos/detail/<%= article.getId() %>" class="card-link btn btn-danger">Détail</a>
								  </div>
								</div>
							</div>
					
					<% } %>
					<!-- Fin Code Java -->
				</div>
					

				
				
			</div>
		</main>
		
		<footer class="row text-center">
			<p>
				<small>Blog Dev &copy; 2023</small> 
			</p>
		</footer>
		
	</div>
</body>
</html>