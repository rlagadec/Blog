<%
	String [][] menu = {
		{"Accueil","/"},
		{"Tutos","/tutos"},
		{"Contact","#"},
		{"A propos","#"},
		{"Ajouter un article","/tutos/ajouter"}
	};
	String appName = (String) application.getInitParameter("APP_NAME");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><%= appName %></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav me-auto">
				<% for( String [] item : menu ){  %>
				<li class="nav-item"><a class="nav-link"
					href="<%= request.getContextPath()+item[1] %>"> <%= item[0] %>
				</a></li>
				<% } %>
			</ul>
			<form class="d-flex">
				<input class="form-control me-sm-2" type="search"
					placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>