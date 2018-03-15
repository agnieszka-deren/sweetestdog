<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
<title>Register</title>
</head>

<body>
	<jsp:include page="navfoot/navbar.jspf" />

	
<div class="container">
	<div class="col-sm-6 col-md-4 col-md-offset-4">
			<form action="register" class="form-signin" method="post">
			<h1 class="form-signin-heading col-md-offset-4">Rejestracja</h1>
			<label for="inputEmail">Podaj e-mail:</label>
            <input name="inputEmail" type="email" class="form-control" placeholder="E-mail" required autofocus />
            <label for="inputUsername">Podaj nazwę użytkownika:</label>
            <input name="inputUsername" type="text" class="form-control" placeholder="Nazwa użytkownika" required autofocus />
            <label for="inputPassword">Podaj hasło:</label>
            <input name="inputPassword" type="password" class="form-control" placeholder="Hasło" required />
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Zarejestruj</button>			
			</form>
	</div>	
</div>

<jsp:include page="navfoot/footer.jspf" />

   
   
   <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
   <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>