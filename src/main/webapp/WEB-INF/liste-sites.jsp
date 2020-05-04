<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Sites</title>
</head>
<body>
	<h1>Liste des Sites</h1>
	
	<c:forEach items="${listeDesSites}" var="site">
		<a href="details-site?id=${site.id}"> ${site.nom}</a><BR/>
	</c:forEach>
	
</body>
</html>