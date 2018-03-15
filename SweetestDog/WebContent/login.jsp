<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
<title>Login</title>
</head>
<body>
    <nav class ="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand"><b>The Sweetest Dog</b></a>
        <p class="navbar-text">photos make you smile</p>
         
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
          <span class="glyphicon glyphicon-list"></span>
        </button>
	<div class="collapse navbar-collapse navHeaderCollapse"> 
	<ul class="nav navbar-nav navbar-right">
		<li><a href="">Główna</a></li>
		<!--  <li><a href="">Poczekalnia</a></li> -->
		<li><a href="">Dodaj</a></li>
		<li><a href="">Zaloguj</a></li>
	</ul>
	</div>
	</div>
	</nav>
		<div class="container">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				  <form class="form-signin" action="j_security_check" method="post">
            		<h1 class="form-signin-heading col-md-offset-4">Logowanie</h1>
            		<label for="j_username">Nazwa użytkownika:</label>
            		<input name="j_username" type="text" class="form-control" placeholder="Podaj nazwę użytkownika" required autofocus>
            		<label for="j_password">Hasło:</label>
            		<input name="j_password" type="password" class="form-control" placeholder="Podaj hasło" required>
           			 <button class="btn btn-lg btn-default btn-block" type="submit">Zaloguj</button>
            		<a href="${pageContext.request.contextPath}/register">Rejestracja</a>
        </form>
			</div>
		</div>

<footer class="footer" >
<div class="container">
<p class="navbar-text"> Created by AgnieszkaDeren</p>
</div>
</footer>
   
   
   <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
   <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>


</body>
</html>