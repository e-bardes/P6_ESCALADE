<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inscription</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<style type="text/css"><%@ include file="/style/style2.css" %></style>
	
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div>
		<%@ include file="/WEB-INF/common/navigation.jspf" %>
	</div>
	
	<section>
		
		<!-- en cas d'erreur, le mot de passe est le seul champs qui n'est pas re-rempli automatiquement.
			tous les champs sont obligatoires à part l'adresse postal -->
		<div class="container jumbotron bg-white mt-5 border">
			<form action="<c:url value="/register" />" method="post" class="col-4">
				<div class="form-group">		
					<label for="nom">Nom : <span class="requis">*</span></label> 
					<!-- c:out pour échapper les caractères spéciaux -->
					<input class="form-control" type="text" name="nom" id="nom" 
						value="<c:out value="${utilisateur.nom}"/>" required>
				</div>
				<div class="form-group">
					<label for="prenom">Prenom : <span class="requis">*</span></label> 
					<input class="form-control" type="text" name="prenom" id="prenom" 
						value="<c:out value="${utilisateur.prenom}"/>" required>
				</div>
				<div class="form-group">
					<label for="adressemail">Adresse mail : <span class="requis">*</span></label>
					<input class="form-control" type="email" name="adressemail" id="adressemail" 
						value="<c:out value="${utilisateur.adresseMail}"/>" required>
					<span class="erreur">${erreurs['adressemail']}</span>
				</div>
				<div class="form-group">
					<label for="adressepostal">Adresse postal : </label> 
					<input class="form-control" type="text" name="adressepostal" id="adressepostal" 
						value="<c:out value="${utilisateur.adressePostal}"/>">
				</div>
				<div class="form-group">
					<label for="password">Mot de passe : <span class="requis">*</span></label> 
					<input class="form-control" type="password" name="password" id="password" required>
					<span class="erreur">${erreurs['password']}</span>
				</div>
				<div class="form-group">
					<label for="confirmation">Confirmation du mot de passe : <span class="requis">*</span></label> 
					<input class="form-control" type="password" name="confirmation" id="confirmation" required>
				</div>
				<div class="form-group">
					<label for="membreAssociation">Je suis un membre de l'association</label>
					<input type="checkbox" id="membreAssociation" name="membreAssociation">
				</div>
				
				<button class="btn btn-primary" type="submit"> Register </button> <br/>
				
			</form>
		</div>
	
	</section>
	
	<div>
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
    
</body>
</html>