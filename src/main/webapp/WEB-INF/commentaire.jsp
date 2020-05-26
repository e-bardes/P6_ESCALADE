<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style type="text/css"><%@ include file="/style/style2.css" %></style>
	<title>Commentaire</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<%@ include file="/WEB-INF/common/header.jspf"%>
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>
		
	<section>
		<div class="container bg-white mt-5 border">
			<!-- différents affichages pour l'éditer ou la création d'un commentaire -->
			<c:choose>
				<c:when test="${param.isEditing == true}">
					<form action="<c:url value="postercommentaire?siteId=${param.siteId}
						&commentaireId=${param.commentaireId}&isEditing=true"/>" method="POST">
						<p><label for="contenuDuCommentaire"> Contenu du commentaire : </label> </p>
						<textarea name="contenuDuCommentaire" rows="10" cols="50">
						<c:out value="${requestScope.commentaire.contenu}"/></textarea>
						<input type="submit" value="Commenter"/>
					</form>
				</c:when>
				<c:otherwise>
					<form action="<c:url value="postercommentaire?siteId=${param.siteId}
						&commentaireId=${param.commentaireId}&isEditing=false"/>" method="POST">
						<p><label for="contenuDuCommentaire"> Contenu du commentaire : </label> </p>
						<textarea name="contenuDuCommentaire" rows="10" cols="50"></textarea>
						<input type="submit" value="Commenter"/>	
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
		
	<div class="container">
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>