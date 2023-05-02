<%@page import="helpers.Flash"%>
<%@page import="bo.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Article article = (Article) request.getAttribute("article");
%>
<%
String info = Flash.getMessage("success", session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Imports css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/css/style.css">
<!-- fin import css -->
<title>Détail <%=article.getTitle()%></title>
</head>
<body>
	<div class="container-fluid">
		<header class="row">
			<%@ include file="/WEB-INF/jsp/parts/menu.jsp"%>
		</header>

		<main class="row mt-5">
			<div class="col-8 offset-2">
				<%
				if (info != null) {
				%>
				<div class="alert alert-success text-center"><%=info%></div>
				<%
				}
				%>
				<div class="row text-center">
					<h1>
						Détail
						<%=article.getTitle()%></h1>
				</div>
				<div class="row mt-5 text-center">
					<!-- Code Java -->
					<p>
						Contenu:
						<%=article.getContent()%>
					</p>
					<p>
						Auteur:
						<%=article.getAuthor()%>
					</p>
					<p>
						Date de création:
						<%=article.getDateCreation()%>
					</p>
					<!-- Fin Code Java -->
				</div>
				<div class="row mt-5 text-center">
					<div class="col-2 offset-4">
						<a
							href="<%=request.getContextPath()%>/tutos/modifier/<%=article.getId()%>"
							class="btn btn-info">Modifier</a>
					</div>
					<div class="col-2">
						<a
							onclick="return confirm('Voulez-vous vraiment supprimer cet article ?');"
							href="<%=request.getContextPath()%>/tutos/supprimer/<%=article.getId()%>"
							class="btn btn-danger">Supprimer</a>
					</div>
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