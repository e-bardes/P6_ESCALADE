<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des topos</title>
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
		
		<section>
			<div class="container jumbotron bg-white mt-5 border" id="test">
				<h1>Description du site</h1>
			
				<p>Nom: ${site.nom} <br/>
				Certification: ${site.isOfficielLesAmisDeLescalade} </p>
				
				<c:if test="${not empty adressemail}">
				<p> <a href="postercommentaire">Poster un commentaire</a> </p>
				</c:if>
				
				<ul>
					<c:forEach items="${listecommentaires}" var="commentaire">
						
							<li> <p> Posté par ${commentaire.utilisateurConnecte.adresseMail} : <br/>
							 ${commentaire.contenu} </p> </li>
					</c:forEach>
				</ul>
			</div>
		
		</section>
	
		<div class="container">
	      <%@ include file="/WEB-INF/common/footer.jspf" %>
	    </div>
			
		<%@ include file="/WEB-INF/common/bootstrap.jspf" %>
</body>
</html>