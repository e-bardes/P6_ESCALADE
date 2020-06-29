<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Succès de l'inscription</title>
	
	<style type="text/css"><%@ include file="/style/style2.css" %></style>

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div>
		<!--  %@ include file="/WEB-INF/common/header.jspf" %-->
		<%@ include file="/WEB-INF/common/navigation.jspf" %>
	</div>
	
	<!-- après s'être inscrit avec succès -->
	<section class="container">
		<div class="jumbotron bg-white mt-5 border min-vh-100">
            <p>Nom : <c:out value="${ requestScope.nom }"/></p>
            <p>Prénom : <c:out value="${ requestScope.prenom }"/></p>
            <c:if test="${ requestScope.adressePostal != '' }">
            	<p>Adresse : <c:out value="${ requestScope.adressePostal }"/></p>
            </c:if>
            <p>Email : <c:out value="${ requestScope.adresseMail}"/></p>
            <p>Vous pouvez maintenant vous connecter.</p>
		</div>
	</section>
	
	
	
	<div>
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
</body>
</html>