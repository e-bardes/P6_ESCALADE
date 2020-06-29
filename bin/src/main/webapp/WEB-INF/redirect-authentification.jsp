<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<style type="text/css"><%@ include file="/style/style2.css" %></style>
		<title>Redirect Authentification</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
		 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	
	<div>
		<!--  %@ include file="/WEB-INF/common/header.jspf" %-->
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>
	
	<!-- quand on est redirigé, on a le choix entre se connecter ou s'inscrire -->	
	<section class="container">
		<div class="jumbotron bg-white mt-5 border min-vh-100">
			<p><a href="<c:out value="login"/>">Se connecter</a></p>
			<p><a href="<c:out value="register"/>">S'inscrire</a></p>
		</div>
	</section>
		
	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>