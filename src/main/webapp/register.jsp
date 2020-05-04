<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<c:if test="${not empty password}">
	Champ(s) non valide(s). Veuillez réessayer.<br/>
	</c:if>
	
	<form action="register" method="POST">
		Nom : <input type="text" name="nom"/><br/>
		Prenom : <input type="text" name="prenom"/><br/>
		Adresse mail : <input type="text" name="adresse-mail"/><br/>
		Adresse postal : <input type="text" name="adresse-postal"/><br/>
		Login : <input type="text" name="login"/><br/>
		Mot de passe : <input type="password" name="password"/><br/>
		Confirmation du mot de passe : <input type="password" name="password"/><br/>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>