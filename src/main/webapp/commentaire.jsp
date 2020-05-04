<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="details-site?id=${site.id}" method="POST">
		Contenu du commentaire : <input type="text" name=contenuDuCommentaire/><BR/>
		<input type="submit" value="Commenter"/>
	</form>
</body>
</html>