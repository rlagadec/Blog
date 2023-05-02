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
<title>Inscription</title>
</head>
<body>
	<div class="container-fluid">
		<header class="row">
			<%@ include file="/WEB-INF/jsp/parts/menu.jsp"%>
		</header>
		<div class="registration mx-auto d-block w-100">
			<div class="page-header text-center">
				<h1>Sign up</h1>
			</div>
	<main>
		<div class="row">
			<div class="col-6 offset-3">
				<form id="member-registration"
				action="" method="post" class="form-validate form-horizontal well">
				<fieldset>
					<legend>Utilisateur</legend>
					<div class="form-group">
						<label for="firstname">Prénom *</label> <input
							type="text" class="form-control" name="firstname" id="firstname">
					</div>
					<div class="form-group">
						<label for="lastname">Nom *</label> <input
							type="text" class="form-control" name="lastname" id="lastname">
					</div>
					<div class="form-group">
						<label for="email">Email *</label> <input
							type="email" class="form-control" name="email" id="email">
					</div>
					<div class="form-group">
						<label for="username">Nom d'utilisateur*</label> <input
							type="password" class="form-control" name="username" id="username">
					</div>
					<div class="form-group">
						<label for="password">Password*</label> <input
							type="password" class="form-control" name="password" id="password">
					</div>
					<div class="d-flex justify-content-between align-items-center">
						<div class="form-group d-flex justify-content-start">
							<button type="submit" class="btn btn-primary mt-3">S'inscrire</button>
						</div>
						<div class="form-check form-group d-flex justify-content-end">
							<a href="#">Sign in instead</a>
						</div>
					</div>
				</fieldset>
			</form>
			
			
			</div>
		
		</div>
	
	
	</main>
			
		</div>
	</div>
</body>
</html>