<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
<title>CONNEXION</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row">
			<%@ include file="/WEB-INF/jsp/parts/menu.jsp"%>
		</header>
		<div class="registration mx-auto d-block w-100">
			<div class="page-header text-center">
				<h1>Connexion</h1>
				<form method="post">
				<div class="row">
					<div>
						<label>Nom d'utilisateur</label> <input type="text" name="username">
					</div>
					<div>
						<label>Mot de passe</label> <input type="password" name="password">
					</div>
					</div>
					<button type="submit">Se connecter</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>