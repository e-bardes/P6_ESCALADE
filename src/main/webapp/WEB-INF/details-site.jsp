<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des topos</title>
<style type="text/css"><%@include file="/style/style2.css"%></style>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body class="bg-light">
	<div>
		<!--  %@ include file="/WEB-INF/common/header.jspf" %-->
	</div>

	<div>
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>

	<section class="container ">
		<h1 class="text-center jumbotron p-4">Description du site</h1>
		<div class="jumbotron bg-white mt-5 mb-5 border min-vh-100">
		
			<c:if test="${ site.isOfficielLesAmisDeLescalade == true }">
				<img src="<c:url value="img/isOfficielLesAmisDeLescalade.png"/>" style="width: 5%" />
			</c:if>

			<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
				<c:choose>
					<c:when test="${site.isOfficielLesAmisDeLescalade == true}">
						<p>
							<a href="<c:url value="modifierofficialisationSite?siteId=${site.id}"/>"> Desofficialiser ce site</a>
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<a href="<c:url value="modifierofficialisationSite?siteId=${site.id}"/>"> Officialiser ce site</a>
						</p>
					</c:otherwise>
				</c:choose>
			</c:if>

			<!-- description du site -->
			
			<p>
				${site.description}
			</p>
			<p>
				Nom: ${site.departement} <br/> Certification: ${site.isOfficielLesAmisDeLescalade}
			</p>
			
			<!-- pour ajouter un nouveau commentaire -->
			<p>
				<a href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=null&isEditing=false"/>"> Poster un
					commentaire</a>
				<a class="ml-3" href="<c:url value="modifierinformations?siteId=${site.id}"/>">Ajouter des informations sur ce site</a>
			</p>
			
			<h2>Commentaires:</h2>
			
			<ul>
				<c:forEach items="${listecommentaires}" var="commentaire">
					<li>
						<!-- affichage des commentaires parent -->
						<p>Posté par ${commentaire.utilisateur.prenom} ${commentaire.utilisateur.nom} :</p>
						<div class="container">
							<div class="row">
								<div class="col-8 border text-break mb-3 p-3">
									<p>${commentaire.contenu}</p>
								</div>
								<div class="col-4">
									<!-- pour répondre après un commentaire et ses potentielles réponses -->
									<p>
										<a href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=${commentaire.id}&isEditing=false"/>">
											Répondre à ce commentaire </a>
									</p>
									<!-- suppression ou édition d'un commentaire par un admin -->
									<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
										<p>
											<a class="text-danger"
												href="<c:url value="supprimercommentaire?siteId=${site.id}&commentaireId=${commentaire.id}"/>">
												Supprimer ce commentaire</a>
										</p>
										<p>
											<a class="text-danger"
												href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=${commentaire.id}&isEditing=true"/>">
												Editer ce commentaire</a>
										</p>
									</c:if>
								</div>
							</div>

							<!-- affichage des réponses aux commentaires parents -->
							<c:forEach items="${listerepcommentaires}" var="repcommentaire">
								<c:if test="${repcommentaire.commentaireParent.id == commentaire.id}">
									<div class="collapse row" id="collapse${commentaire.id}">
										<p class=col-12>Posté par ${repcommentaire.utilisateur.prenom} ${repcommentaire.utilisateur.nom} :</p>
										<div class="col-8 border text-break mb-3 ml-5 p-3">
											<p>${repcommentaire.contenu}</p>
										</div>
										<div class="col-3">
											<!-- suppression ou édition d'un commentaire par un admin -->
											<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
												<p>
													<a class="text-danger"
														href="<c:url value="supprimercommentaire?siteId=${site.id}&commentaireId=${repcommentaire.id}"/>">
														Supprimer ce commentaire</a>
												</p>
												<p>
													<a class="text-danger"
														href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=${repcommentaire.id}&isEditing=true"/>">
														Editer ce commentaire</a>
												</p>
											</c:if>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div> <!-- pour pouvoir afficher ou masquer les réponses d'un commentaire --> <c:if
							test="${!empty commentaire.listeReponses}">
							<div class="mb-3">
								<a data-toggle="collapse" href="#collapse${commentaire.id}" aria-expanded="false"
									aria-controls="collapse${commentaire.id}"> Afficher les réponses </a>
							</div>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
	</section>

	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>
</body>
</html>