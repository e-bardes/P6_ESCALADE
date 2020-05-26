<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css"><%@ include file="/style/style2.css" %></style>

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/common/header.jspf" %>
		<%@ include file="/WEB-INF/common/navigation.jspf" %>
	</div>
	
	<!-- après s'être inscrit avec succès -->
	<section>
		<div class="container jumbotron bg-white mt-5 border">
			<p>${ resultat }</p>
            <p>Nom : <c:out value="${ utilisateur.nom }"/></p>
            <p>Prénom : <c:out value="${ utilisateur.prenom }"/></p>
            <p>Adresse : <c:out value="${ utilisateur.adressePostal }"/></p>
            <p>Email : <c:out value="${ utilisateur.adresseMail}"/></p>
            <p>Vous pouvez maintenant vous connecter.</p>
		</div>
	</section>
	
	
	
	<div class="container">
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
</body>
</html>