<%@page import="bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Article article = (Article) request.getAttribute("article"); %>    
<% List<String> erreurs = (List<String> ) request.getAttribute("erreurs");  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- Imports css -->
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/style.css">
	<!-- fin import css -->
	<title>Modifier un article</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row" >
			<%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
		</header>
		
		<main class="row mt-5">
			<div class="row text-center">
				<h1>Modifier un article</h1>
			</div>
			<div class="col-8 offset-2">
				<%  if( erreurs!=null ) for(String erreur : erreurs){ %>
					<div class="alert alert-danger">
						<%= erreur %>
					</div>	
				<% } %>
				
				<form action="" method="POST" >
				
					<div class="form-group">
					  <label for="title" class="form-label mt-4">Titre</label>
					  <input type="text" class="form-control" 
					  id="title" name="title" value="<%= article.getTitle()  %>"  placeholder="ex. Tuto Spring">  
					</div>
									
				    <div class="form-group">
				      <label for="content" class="form-label mt-4">Contenu</label>
				      <textarea class="form-control" id="content" 
				      name="content" rows="3"><%= article.getContent()  %></textarea>
				    </div>	
				    
					<div class="form-group">
					  <label for="author" class="form-label mt-4">Auteur</label>
					  <input type="text" class="form-control" 
					  id="author" name="author" value="<%= article.getAuthor()  %>" placeholder="ex. Pierre">  
					</div>
				    <button type="submit" class="btn btn-primary mt-3">Modifier</button>			
				</form>
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