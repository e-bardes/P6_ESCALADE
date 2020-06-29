<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<%@include file="/style/style2.css"%></style>
<title>Demandes reçues</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
	<script src="https://kit.fontawesome.com/56a2cfb089.js" crossorigin="anonymous"></script>
</head>

<body class="bg-light">

	<div>

		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>

	<section class="container">

		<h1 class="text-center jumbotron p-4">Liste des demandes de réservation :</h1>
		<div class="jumbotron bg-white mt-5 border h-auto min-vh-100">

			<div class="card-deck">
				<c:forEach items="${listedemandesreservationrecues}" var="topo">
					<c:forEach items="${topo.applicantList}" var="utilisateur">
						<div class="mb-5 col-12">
							<div class="card">
								<div class="card-header text-center">
									<h4 class="card-title">Demande de : ${utilisateur.prenom} ${utilisateur.nom}</h4>
									<!-- adresse mail affiché une fois  -->
									<c:if test="${ not empty topo.possessor}">
										<p class="card-title">
											Mail de contact: ${utilisateur.adresseMail}
											Adresse postal: ${utilisateur.adressePostal}
										</p>
									</c:if>
								</div>
								<div class="card-body">				
									<p class="card-text">Pour le topo : ${topo.nom}</p>
									<c:choose>
									<!-- si il n'y a pas de possesseur actuel (càd disponible et toujours en attente de réservation) -->
										<c:when test="${empty topo.possessor}">
											<form action="<c:url value="listedemandesreservationrecues?topoId=${topo.id}
												&utilisateurId=${utilisateur.id}&acceptation=true"/>" method="post">
												<button class="btn btn-success" type="submit"> Accepter sa demande </button>
											</form>
											<form action="<c:url value="listedemandesreservationrecues?topoId=${topo.id}
												&utilisateurId=${utilisateur.id}&acceptation=false"/>" method="post">
												<button class="btn btn-danger" type="submit"> Refuser sa demande </button>
											</form>
										</c:when>
										<c:otherwise>
											<form action="<c:url value="listedemandesreservationrecues?topoId=${topo.id}
												&utilisateurId=${utilisateur.id}&acceptation=false"/>" method="post">
												<button class="btn btn-danger" type="submit"> Supprimer le message </button>
											</form>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</section>
	
	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>