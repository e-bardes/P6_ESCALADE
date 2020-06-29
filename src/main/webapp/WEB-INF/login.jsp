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
	
	<div>
		<%@ include file="/WEB-INF/common/navigation.jspf" %>
	</div>

	<section class="container">
    	<div class="jumbotron bg-white mt-5 border min-vh-100">
			
			<form action="<c:url value="/login" />" method="post" class="col-4">
				<div class="form-group">
					<label for="adressemail"> Email : </label> 
					<input class="form-control" type="email" name="adressemail" id="adressemail"
						value="<c:out value="${utilisateur.adresseMail}"/>" required>
				</div>
				<div class="form-group">
					<label for="password">Mot de passe :</label> 
					<input class="form-control" type="password" name="password" id="password" required>
					<span class="erreur">${erreurConnexion}</span>
				</div>
				<button class="btn btn-primary" type="submit"> Login </button>
				<br/>
				<!-- affichage du succès ou de l'échec de la connexion -->
				<p class="${empty erreurConnexion ? 'succes' : 'erreur'}">${resultat}</p>

			</form>
  		</div>

    </section>
	
	<div>
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
	
	
</body>
</html>