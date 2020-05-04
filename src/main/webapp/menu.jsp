<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Les amis de l'escalade</title>
</head>
<body>
	<c:if test="${not empty login}">
	Bonjour ${login} (<a href="logout">Déconnexion</a>)<br/>
	</c:if>
	<h1>Les amis de l'escalade</h1>
	<a href="login.html">Se connecter</a><br/>
	<a href="register.jsp">S'inscrire</a><br/>
	<a href="topo">Consulter la liste des topos</a><br/>
	<a href="site">Consulter la liste des sites</a>
	
	
	
</body>
</html>