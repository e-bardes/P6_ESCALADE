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
	<h1>Description du site</h1>
	
	Nom: ${site.nom} <BR/>
	Certification: ${site.isOfficielLesAmisDeLescalade} <BR/>
	
	<c:if test="${not empty login}">
	<a href="commentaire.jsp">Poster un commentaire</a><br/>
	</c:if>
	<!-- Le commentaire est ${request.contenuDuCommentaire} --><br/>
</body>
</html>