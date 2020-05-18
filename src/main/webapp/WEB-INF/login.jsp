<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css"><%@ include file="/style/style2.css" %></style>
	<title>Connexion</title>
	
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
	  		<c:if test="${not empty adressemail}">
			Champ(s) non valide(s). Veuillez réessayer.<br/>
			</c:if>
			
			<form action="login" method="POST" class="col-4" novalidate>
				<div class="form-group">
					<label for="adressemail"> Email : </label> 
					<input class="form-control" type="email" name="adressemail" id="adressemail"
						value="<c:out value="${utilisateur.adresseMail}"/>" required>
				</div>
				<div class="form-group">
					<label for="password">Mot de passe :</label> 
					<input class="form-control" type="password" name="password" id="password" required>
					<span class="erreur">${form.erreurConnexion}</span>
				</div>
				<button class="btn btn-primary" type="submit"> Login </button>
				<br/>
				<p class="${empty form.erreurConnexion ? 'succes' : 'erreur'}">${form.resultat}</p>
				
				<c:if test="${!empty sessionScope.sessionUtilisateur}">
					<p class="succes">Vous êtes connecté(e) avec l'adresse : 
						${sessionScope.sessionUtilisateur.adresseMail}</p>
				</c:if>
			</form>
  		</div>

    </section>
	
	<div class="container">
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
		
	<%@ include file="/WEB-INF/common/bootstrap.jspf" %>
	
	
</body>
</html>