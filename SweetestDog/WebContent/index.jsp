<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--   PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
<title>TheSweetestDog</title>
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
		<li><a href="${pageContext.request.contextPath}/add">Dodaj</a></li>
		<c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li><a href="logout">Wyloguj się</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login">Zaloguj się</a></li>
                </c:otherwise>
            </c:choose>
	</ul>
	</div>
	</div>
	</nav>
	
<c:if test="${not empty requestScope.photos}">
	 <c:forEach var="photo" items="${requestScope.photos}">
    		<div class="container">
      			<div class="row bs-callout bs-callout-default">
        		<div class="col col-md-2 col-sm-4">
       			<a href="${pageContext.request.contextPath}/score?photo_id=${photo.id}" class="btn btn-lg btn-success">
       			<span class="glyphicon glyphicon-thumbs-up"></span></a>
            	<div class="well well-sm centered"><c:out value="${photo.actualScore}" /></div>
           
        </div>
        <div class="col col-md-10 col-sm-8">
          <h4 class="centered"><a href="<c:out value="${photo.url}"/>"><c:out value="${photo.name}" /></a></h4>
          <h6><small>Dodane przez:<c:out value="${photo.user.username}" />, 
          Dnia: <fmt:formatDate value="${photo.timestamp}" pattern="dd-MM-YYYY"/></small></h6>
          <p><c:out value="${photo.desc}" /></p>
          <a class="btn btn-default btn-xs" href="<c:out value="${photo.url}" />" >Zobacz stronę</a>
        </div>
      </div>
      </div>
   </c:forEach>
 </c:if>  


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