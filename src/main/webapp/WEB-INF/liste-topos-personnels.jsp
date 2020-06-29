<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<%@include file="/style/style2.css"%></style>
<title>Topos personnels</title>

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

		<h1 class="text-center jumbotron p-4">Liste des Topos personnels:</h1>
		<div class="jumbotron bg-white mt-5 border h-auto min-vh-100">

			<!-- liste des topos -->
			<div class="card-deck">
				<c:forEach items="${listedestopos}" var="topo">
					<div class="mb-5 col-12">
						<div class="card">
							<div class="card-header text-center">
								<h4 class="card-title">${topo.nom}</h4>
								<p class="card-text">${topo.lieu}</p>
								<p class="card-text">Date de parution: ${topo.dateDeParution}</p>
								<!-- option de récupération si le topo n'est pas en possession du propriétaire et qu'il est 
									entre les mains d'un autre utilisateur -->
									<c:if test="${(topo.possessor.id != topo.owner.id) and (topo.possessor.id != null) and
										topo.owner.id == curentUserId}">
										<form action="<c:url value="changement-etat-emprunt?topoId=${topo.id}
												&utilisateurId=${topo.possessor.id}"/>" method="post">
											<button class="btn btn-success" type="submit"> Récupérer ce topo </button>
										</form>
									</c:if>	
									<c:if test="${topo.owner.id == curentUserId}">
										<c:choose>
											<c:when test="${empty topo.possessor}">
												<p class="card-text">Est disponible:
												<a href="<c:url value="modifierdisponibilitetopo?topoId=${topo.id}"/>"> 
													<i class="fas fa-check"></i>
													<i class="fas fa-times" style="opacity:0.2;"></i>
												</a>	
											</c:when>
											<c:otherwise>
												<p class="card-text">Est disponible:
												<a href="<c:url value="modifierdisponibilitetopo?topoId=${topo.id}"/>"> 
													<i class="fas fa-check" style="opacity:0.2;"></i>
													<i class="fas fa-times"></i>
												</a>
											</c:otherwise>
										</c:choose>
									</c:if>
								</div>
							<div class="card-body">
								<p class="card-text">${topo.description}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			
			<!-- ajout d'un topo -->
			<div class="container">
				<button class="btn btn-primary btn-lg" type="button" data-toggle="collapse" data-target="#collapse">
					<i class="fas fa-plus"></i><br>Ajouter un topo</button>
				
				<form class="my-3" action="<c:url value="topospersonnel" />" method="post">
					<div class="collapse form-group mr-2" id="collapse">
					
						<div class="form-group">
							<input class="form-control col-4" type="text" placeholder="Nom" name="nomTopo" required>
						</div>
						<div class="form-group">
							<select name="departement" class="form-control col-4" required>
								<option value="">Département</option>											
									<c:forEach items="${listeDepartements}" var="departement">
										<option value="${departement.valeurDepartement}">${departement.valeurDepartement}</option>
									</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<input class="form-control col-4" type="date" placeholder="Date de parution" name="date" required>
						</div>
						<div class="form-group">
							<label for="isDisponible">Le topo est-il disponible ?</label> 
							<input type="checkbox" name="isDisponible">
						</div>
						<div class="form-group">
								<textarea class="form-control col" placeholder="Description" name="description" required></textarea>
						</div>
						<div class="form-group">
							<button class="btn btn-primary" type="submit"> Ajouter </button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>


	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>
</html>