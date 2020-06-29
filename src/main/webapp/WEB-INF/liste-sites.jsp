<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<%@include file="/style/style2.css"%></style>
<title>Liste des Sites</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="bg-light">

	<div>

		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>

	<section class="container">

		<h1 class="text-center jumbotron p-4">Liste des Sites :</h1>
		<div class="jumbotron bg-white mt-5 border h-auto min-vh-100">
			<!-- barre de recherche -->

			<p>Choisissez un ou plusieurs critères :</p>

			<form class="form-inline mb-5" action="<c:url value="/search" />" method="get">
				<div class="form-group mr-sm-2">
					<select id="departement" name="departement" class="form-control">
						<option value="">Départements</option>
						<c:forEach items="${ listeDepartements }" var="departement">
							<option value="${departement.valeurDepartement}">${departement.valeurDepartement}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mr-sm-2">
					<select id="cotation" name="cotation" class="form-control">
						<option value="">Cotation</option>
						<optgroup label="Cotation Bloc">
							<c:forEach items="${ listeCotationBloc }" var="cotationBloc">
								<option value="${cotationBloc.valeurCotation}">${cotationBloc.valeurCotation}</option>
							</c:forEach>
						</optgroup>
						<optgroup label="Cotation Falaise">
							<c:forEach items="${ listeCotationFalaise }" var="cotationFalaise">
								<option value="${cotationFalaise.valeurCotation}">${cotationFalaise.valeurCotation}</option>
							</c:forEach>
						</optgroup>
					</select>
				</div>
				<input class="form-control w-25 mr-sm-2" type="number" name="nombreSecteurs" id="nombreSecteurs"
					placeholder="Nombre de secteurs minimum"> 
				<input class="form-control w-25 mr-sm-2" type="number"
					name="nombreVoies" id="nombreVoies" placeholder="Nombre de voies minimum">

				<button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
			</form>

			<!-- affichage des sites -->
			<div class="card-deck">
				<c:forEach items="${listeDesSites}" var="site" varStatus="status">
					<div class="col-4 mb-5">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">
									<a href="<c:url value="details-site?id=${site.id}"/>">${site.nom}</a>
								</h4>
								<p class="card-text">${site.departement.valeurDepartement}</p>
							</div>
							<div class="card-body">
								<p class="card-text">Nombre de secteurs: ${listeNbSecteurs[status.index]}</p>
								<p class ="card-text">Nombre de voies: ${listeNbVoies[status.index]}</p>
								<c:choose>
									<c:when test="${not empty cotationList[1][status.index] }">
										<p class="card-text">Type de cotation: Bloc</p>
										<p class="card-text">Cotation Minimal: ${cotationList[0][status.index].valeurCotation}</p>
										<p class="card-text">Cotation Maximal: ${cotationList[1][status.index].valeurCotation}</p>
									</c:when>
									<c:otherwise>
										<p class="card-text">Type de cotation: Falaise</p>
										<p class="card-text">Cotation Minimal: ${cotationList[2][status.index].valeurCotation}</p>
										<p class="card-text">Cotation Maximal: ${cotationList[3][status.index].valeurCotation}</p>
									</c:otherwise>
								</c:choose>
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