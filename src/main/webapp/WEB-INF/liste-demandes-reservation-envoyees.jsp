<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<%@include file="/style/style2.css"%></style>
<title>Liste des Topos</title>

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

		<h1 class="text-center jumbotron p-4">Liste des Topos demandés :</h1>
		<div class="jumbotron bg-white mt-5 border h-auto min-vh-100">

			<div class="card-deck">
				<c:forEach items="${listetoposdemandes}" var="topo">
					<div class="mb-5 col-12">
						<div class="card">
							<div class="card-header text-center">
								<h4 class="card-title">${topo.nom}</h4>
								<p class="card-text">${topo.lieu}</p>
								<p class="card-text">Date de parution: ${topo.dateDeParution}</p>
							</div>
							<div class="card-body">				
								<p class="card-text">${topo.description}</p>
									<c:forEach items="${topo.listeEmpruntsTopo}" var="empruntTopo">
										<c:if test="${empruntTopo.id.isPossede == false and empruntTopo.id.isPossesseur == false}">
											<span class="text-success border p-2 mt-2"> Demande de réservation envoyée </span>
										</c:if>
										<c:if test="${empruntTopo.id.isPossede == true and empruntTopo.id.isPossesseur == false}">
											<span class="text-success border p-2 mt-2"> Demande de réservation acceptée </span>
										</c:if>
									</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>


	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>