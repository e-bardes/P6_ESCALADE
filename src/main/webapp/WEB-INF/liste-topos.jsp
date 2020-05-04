<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des topos</title>
</head>
<body>
	<h1>Liste des topos</h1>
	
	<c:forEach items="${listedestopos}" var="topo">
		${topo.nom}<BR/>
	</c:forEach>
</body>
</html>