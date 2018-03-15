<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
<title>Add photo</title>
</head>
<body>

<jsp:include page="navfoot/navbar.jspf" />
	
	 <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-signin" method="post" action="add">
                <h1 class="form-signin-heading col-md-offset-4">Dodaj adres fotki</h1>
                <label for="inputName">Podaj imię psa:</label>
                <input name="inputName" type="text" class="form-control" placeholder="Imię psa"
                    required autofocus />
                <label for="inputUrl">Tu wklej link do zdjęcia:</label>
                <input name="inputUrl" type="url" class="form-control" placeholder="Adres strony ze zdjęciem"
                    required autofocus /> 
                <label for="inputDescription">Napisz coś o okolicznościach wykonanej fotki:</label>
                <textarea name="inputDescription" rows="5" class="form-control" placeholder="Opis" required autofocus></textarea>
                <input class="btn btn-lg btn-primary btn-block" type="submit"
                    value="Dodaj!" />
            </form>
        </div>
    </div>
    
<jsp:include page="navfoot/footer.jspf" />
	

 <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
   <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>