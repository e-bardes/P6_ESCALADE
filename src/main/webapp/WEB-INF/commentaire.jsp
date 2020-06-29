<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<%@include file="/style/style2.css"%>
</style>
<title>Editer Commentaire</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="bg-light">

	<div>
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>

	<section class="container">
		<h1 class="text-center jumbotron p-4">Contenu du commentaire</h1>
		<div class="jumbotron bg-white mt-5 border min-vh-100">
			<!-- différents affichages pour l'édition ou la création d'un commentaire -->
			<c:choose>
				<c:when test="${param.isEditing == true}">
					<form action="<c:url value="poster-commentaire?siteId=${param.siteId}
						&commentaireId=${param.commentaireId}&isEditing=true"/>" method="POST">
						<div class="form-group">
							<textarea class="form-control" name="contenuDuCommentaire" rows="20"><c:out
									value="${requestScope.commentaire.contenu}" /></textarea>
						</div>
						<input type="submit" value="Valider la modification" />
					</form>
				</c:when>
				<c:otherwise>
					<form action="<c:url value="poster-commentaire?siteId=${param.siteId}
						&commentaireId=${param.commentaireId}&isEditing=false"/>" method="POST">
						<div class="form-group">
							<textarea class="form-control" name="contenuDuCommentaire" rows="20" ></textarea>
						</div>
						<input type="submit" value="Commenter" />
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</section>

	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>