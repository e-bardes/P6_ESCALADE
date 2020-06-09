<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des topos</title>
<style type="text/css">
<%@ include file="/style/style2.css" %>
</style>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"
>
</head>

<body class="bg-light">

	<div>
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>
	<section class="container">
		<h1 class="text-center jumbotron p-4">Edition du site</h1>
		<div class="jumbotron bg-white mt-5 border min-vh-100">
			<!-- Modifer la description du site -->
			<a href="<c:url value="modifierdescriptionsite?siteId=${requestScope.site.id}"/>"> Modifier la description du
				site</a>
			<!-- Créer un secteur -->
			<form class="form-inline mb-3" action="<c:url value="createsecteur?siteId=${requestScope.site.id}" />"
				method="post"
			>
				<div class="form-group mr-sm-2">
					<input class="form-control" type="text" name="nomSecteur" placeholder="Nom du secteur" required>
				</div>
				<button class="btn btn-primary" type="submit">Créer le secteur</button>
			</form>
			<!-- Modifier la description d'un secteur -->
			<form class="form-inline mb-3" action="<c:url value="preeditionsecteur" />" method="post">
				<div class="form-group mr-sm-2">
					<select name="secteurId" class="form-control">
						<option value="">Nom du secteur</option>
						<c:forEach items="${site.listeSecteurs}" var="secteur">
							<option value="${secteur.id}">${secteur.nom}</option>
						</c:forEach>
					</select>
				</div>
				<button class="btn btn-primary" type="submit">Modifier ce secteur</button>
			</form>
			<!-- Modifier le nom d'un secteur  ON PASSE A CA-->
			<form class="form-inline mb-3" action="<c:url value="modifierinformations" />" method="post">
				<div class="form-group mr-sm-2">
					<select id="" name="" class="form-control">
						<option value="">Nom du secteur</option>
						<c:forEach items="$" var="secteur">
							<option value="$">$></option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group mr-sm-2">
					<label for=""></label> <input class="form-control" type="text" name="" id="" required>
				</div>
				<button class="btn btn-primary" type="submit">Valider le changement de nom du secteur</button>
			</form>
			<!-- Ajouter une voie -->
			<form class="form-inline mb-3" action="<c:url value="modifierinformations" />" method="post">
				<div class="form-group mr-sm-2">
					<select id="" name="" class="form-control">
						<option value="">type de cotation: $</option>
						<c:forEach items="$" var="cotation">
							<option value="$">$></option>
						</c:forEach>
					</select>
				</div>
				<!-- vérifier si il existe des secteurs ou pas -->
				<c:if test="$">
					<div class="form-group mr-sm-2">
						<select id="" name="" class="form-control">
							<option value="">Secteur</option>
							<!-- par ordre alphabétique peut être -->
							<c:forEach items="$" var="secteur">
								<option value="$">$</option>
							</c:forEach>
						</select>
					</div>
				</c:if>
				<div class="form-group mr-sm-2">
					<label for="">La voie est-elle équipée ?</label> <input type="checkbox" id="" name="">
				</div>
				<button class="btn btn-primary" type="submit">Ajouter la voie</button>
			</form>
			<!-- si il existe des voies sur ce site. Ajouter une longueur -->
			<c:if test="$">
				<form class="form-inline mb-3" action="<c:url value="modifierinformations" />" method="post">
					<div class="form-group mr-sm-2">
						<select id="" name="" class="form-control">
							<option value="">Secteur</option>
							<!-- faut afficher les voie mais si elles ont pas de nom, faut sélectionner avec l'id peut être -->
							<c:forEach items="$" var="voie">
								<option value="$">$</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group mr-sm-2">
						<select id="" name="" class="form-control">
							<option value="">type de cotation: $</option>
							<c:forEach items="$" var="cotation">
								<option value="$">$></option>
							</c:forEach>
						</select>
					</div>
					<button class="btn btn-primary" type="submit">Ajouter la longueur</button>
				</form>
			</c:if>
		</div>
	</section>
	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>

</html>