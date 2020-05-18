<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>

	<c:if test="${not empty password}">
	Champ(s) non valide(s). Veuillez réessayer.<br/>
	</c:if>

	<form action="login" method="POST">
		Login : <input type="text" name="login"/><br/>
		Mot de passe : <input type="password" name="password"/><br/>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>