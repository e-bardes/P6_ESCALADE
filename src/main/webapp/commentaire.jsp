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
	
	<div>
		<%@ include file="/WEB-INF/common/header.jspf"%>
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>
		
	<section>
		<form action="details-site?id=${site.id}" method="POST">
			<p><label for="contenuDuCommentaire"> Contenu du commentaire : </label> </p>
			<textarea name=contenuDuCommentaire></textarea>
			<input type="submit" value="Commenter"/>
		</form>
		
	</section>
		
	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>