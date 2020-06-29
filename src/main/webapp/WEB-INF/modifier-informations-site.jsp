<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifier informations site</title>
	
	<style type="text/css">
	<%@ include file="/style/style2.css" %>
	</style>
	
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
		<h1 class="text-center jumbotron p-4">Edition du site</h1>
		<div class="jumbotron bg-white mt-5 border min-vh-100">
		
		<c:if test="${not empty site.listeSecteurs}">
			<c:set var="haveSecteurs" value="true" />
		</c:if>
		<c:if test="${ sessionScope.sessionUtilisateur.isMembreAssociation == true}">
			<c:set var="isMembreAssociation" value="true" />
		</c:if>	
		<c:if test="${not empty site.listeVoies[0].cotationBloc}">
			<c:set var="isBloc" value="true" />
		</c:if>
		
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover table-fixed">
				<thead>
					<tr>
						<th>Nom site</th>
						<th>Departement</th>
						<th>Est officiel</th>
						<th>Type de cotation</th>
						<th>Description</th>
						<c:if test="${empty haveSecteurs}">
							<th>Liste des voies et longueurs</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${site.nom}</td>
						<td>${site.departement.valeurDepartement}</td>
						<td>
							<c:choose>
								<c:when test="${ site.isOfficielLesAmisDeLescalade == true }">
									<c:choose>
										<c:when test="${not empty isMembreAssociation}">
											<a href="<c:url value="modifierofficialisationSite?siteId=${site.id}"/>"> 
												<i class="fas fa-check"></i>
												<i class="fas fa-times" style="opacity:0.2;"></i>
											</a>
										</c:when>
										<c:otherwise>
											<i class="fas fa-check"></i>
											<i class="fas fa-times" style="opacity:0.2;"></i>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${not empty isMembreAssociation}">
											<a href="<c:url value="modifierofficialisationSite?siteId=${site.id}"/>"> 
												<i class="fas fa-check" style="opacity:0.2;"></i>
												<i class="fas fa-times"></i>
											</a>	
										</c:when>
										<c:otherwise>
											<i class="fas fa-check" style="opacity:0.2;"></i>
											<i class="fas fa-times"></i>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${(not empty isBloc) or (not empty site.listeSecteurs[0].listeVoies[0].cotationBloc)}">
									Cotation Bloc
								</c:when>
								<c:otherwise>
									Cotation Falaise
								</c:otherwise>
							</c:choose>
						</td>
						<td style="min-width:300px;">
							<p class="overflow-auto">${site.description}</p>
							<a href="<c:url value="modifierdescriptionsite?siteId=${requestScope.site.id}"/>">
								<i class="far fa-edit"></i>
							</a>
						</td>
						
						<c:if test="${empty haveSecteurs}">
							<td>
								<table class="table table-dark">
								<thead>
									<tr>
										<th>Id voie</th>
										<th>Cotation</th>
										<th>Est équipé</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<c:forEach items="${site.listeVoies}" var="voie">
												${voie.id} <br/> <br/>
												<c:forEach items="${voie.listeLongueurs}" var="longueur">
													<br/>
												</c:forEach>
											</c:forEach>
										</td>
										<td>
											<c:choose>
												<c:when test="${not empty isBloc}">
													<c:forEach items="${site.listeVoies}" var="voie">
														-${voie.cotationBloc.valeurCotation} <br/>
														<c:forEach items="${voie.listeLongueurs}" var="longueur">
															&ensp;&ensp;-${longueur.cotationBloc.valeurCotation} <br/>
														</c:forEach>
														<br/>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<c:forEach items="${site.listeVoies}" var="voie">
														-${voie.cotationFalaise.valeurCotation} <br/>
														<c:forEach items="${voie.listeLongueurs}" var="longueur">
															&ensp;&ensp;-${longueur.cotationFalaise.valeurCotation} <br/>
														</c:forEach>
														<br/>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:forEach items="${site.listeVoies}" var="voie">
												<c:choose>
													<c:when test="${voie.isEquipe == true}">
														<i class="fas fa-check"></i>
														<br/> <br/>
													</c:when>
													<c:otherwise>
														<i class="fas fa-times"></i>
														<br/> <br/>
													</c:otherwise>
												</c:choose>
												<c:forEach items="${voie.listeLongueurs}" var="longueur">
														<br/>
												</c:forEach>
											</c:forEach>
										</td>
										<td>
											<c:forEach items="${site.listeVoies}" var="voie">
												<form action="<c:url value="/deletevoieorlongueurorsecteur?voieId=${voie.id}&siteId=${site.id}" />" method="post">
													<button type="submit" name="moins" class="border-0" style="background-color:rgb(69, 77, 85); font-size:13px;">
														<i class="fas fa-ban text-white" style="font-size:13px;"></i>
													</button>
												</form>
												
												<c:forEach items="${voie.listeLongueurs}" var="longueur">
													<form action="<c:url value="/deletevoieorlongueurorsecteur?longueurId=${longueur.id}&siteId=${site.id}" />" method="post">
														<button type="submit" name="moins" class="border-0" style="background-color:rgb(69, 77, 85); font-size:13px;">
															<i class="fas fa-ban text-white" style="font-size:13px;"></i>
														</button>
													</form>
												</c:forEach>
												<br/>
											</c:forEach>													
										</td>
									</tr>
								</table>
								<div class="btn-group">
									<button class="btn btn-primary mt-2" type="button" data-toggle="collapse" data-target="#collapse"
										>Ajouter une voie</button>
									<button class="btn btn-primary  mt-2" type="button" data-toggle="collapse" data-target="#collapse2"
									>Ajouter une longueur</button>
								</div>
								<form action="<c:url value="/ajoutervoie?siteId=${site.id}" />" method="post">
									<div class="collapse form-group mt-2" id="collapse">
										<select name="cotation" class="form-control">
											<option value="">Cotation</option>
											<c:choose>
												<c:when test="${not empty isBloc}">													
													<c:forEach items="${listeCotationBloc}" var="cotationBloc">
														<option value="${cotationBloc.valeurCotation}">${cotationBloc.valeurCotation}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<c:forEach items="${listeCotationFalaise}" var="cotationFalaise">
														<option value="${cotationFalaise.valeurCotation}">${cotationFalaise.valeurCotation}</option>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</select>
										<div class="form-group mt-2">
											<label for="isEquipe">La voie est-elle équipée ?</label> 
											<input type="checkbox" name="isEquipe">
										</div>
										<button class="btn btn-primary  mt-2" type="submit">Ajouter</button>
									</div>
								</form>
								<form action="<c:url value="ajouterlongueur?siteId=${site.id}" />" method="post">
									<div class="collapse form-group mt-2" id="collapse2">
										<select name="cotation" class="form-control">
											<option value="">Cotation</option>
											<c:choose>
												<c:when test="${not empty isBloc}">													
													<c:forEach items="${listeCotationBloc}" var="cotationBloc">
														<option value="${cotationBloc.valeurCotation}">${cotationBloc.valeurCotation}</option>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<c:forEach items="${listeCotationFalaise}" var="cotationFalaise">
														<option value="${cotationFalaise.valeurCotation}">${cotationFalaise.valeurCotation}</option>
													</c:forEach>
												</c:otherwise>
											</c:choose>
											</select>
											<select name="voieId" class="form-control">
												<option value="">Voie</option>
											<c:forEach items="${site.listeVoies}" var="voie">
													<option value="${voie.id}">${voie.id}</option>
											</c:forEach>
										</select>
										<button class="btn btn-primary mt-2" type="submit">Ajouter</button>
									</div>
								</form>
							</td>
						</c:if>
					</tr>
				</tbody>
			</table>
		</div>
     
    <c:if test="${ not empty haveSecteurs}">
	    <div class="table-responsive">
		    <table class="table table-striped table-bordered table-hover">
		      <thead>
		        <tr>
		          <th>Nom secteur</th>
		          <th>Description</th>
		          <th>Liste des voies et longueurs</th>
		          <th>Supprimer</th>
		        </tr>
		      </thead>
		      <tbody>
		      	<c:forEach items="${site.listeSecteurs}" var="secteur">
			        <tr>
			        	<td>
			        		<c:choose>
			        			<c:when test="${nameEditing == secteur.id}">
											<form class="mb-3" action="<c:url value="modifiernomsecteur?secteurId=${secteur.id}&siteId=${site.id}" />" method="post">
												<div class="form-group mr-sm-2">
													<input class="form-control" type="text" placeholder="Nom" name="nomSecteur" required>
												</div>
												<button class="btn btn-primary" type="submit">Valider</button>
											</form>
			        			</c:when>
			        			<c:otherwise>
			        				<p>${secteur.nom}</p>
					        		<a href="<c:url value="modifiernomsecteur?secteurId=${secteur.id}&siteId=${site.id}"/>">
												<i class="far fa-edit"></i>
											</a>
			        			</c:otherwise>
			        		</c:choose>
			        	</td>
			        	<td style="min-width:300px;">
									<p class="overflow-auto">${secteur.description}</p>
									<a href="<c:url value="modifierdescriptionsecteur?secteurId=${secteur.id}"/>">
										<i class="far fa-edit"></i>
									</a>
								</td>
			        	
								<td>
									<table class="table table-dark">
									<thead>
										<tr>
											<th>Id voie</th>
											<th>Cotation</th>
											<th>Est équipé</th>
											<th>Supprimer</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<c:forEach items="${secteur.listeVoies}" var="voie">
													${voie.id} <br/> <br/>
													<c:forEach items="${voie.listeLongueurs}" var="longueur">
														<br/>
													</c:forEach>
												</c:forEach>
											</td>
											<td>
												<c:choose>
													<c:when test="${not empty secteur.listeVoies[0].cotationBloc}">
														<c:forEach items="${secteur.listeVoies}" var="voie">
															-${voie.cotationBloc.valeurCotation} <br/>
															<c:forEach items="${voie.listeLongueurs}" var="longueur">
																&ensp;&ensp;-${longueur.cotationBloc.valeurCotation} <br/>
															</c:forEach>
															<br/>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach items="${secteur.listeVoies}" var="voie">
															-${voie.cotationFalaise.valeurCotation} <br/>
															<c:forEach items="${voie.listeLongueurs}" var="longueur">
																&ensp;&ensp;-${longueur.cotationFalaise.valeurCotation} <br/>
															</c:forEach>
															<br/>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</td>
											<td>
												<c:forEach items="${secteur.listeVoies}" var="voie">
													<c:choose>
														<c:when test="${voie.isEquipe == true}">
															<i class="fas fa-check"></i>
															<br/> <br/>
														</c:when>
														<c:otherwise>
															<i class="fas fa-times"></i>
															<br/> <br/>
														</c:otherwise>
													</c:choose>
													<c:forEach items="${voie.listeLongueurs}" var="longueur">
															<br/>
													</c:forEach>
												</c:forEach>
											</td>
											<td>
												<c:forEach items="${secteur.listeVoies}" var="voie">
													<form action="<c:url value="/deletevoieorlongueurorsecteur?voieId=${voie.id}&siteId=${site.id}" />" method="post">
														<button type="submit" name="moins" class="border-0" style="background-color:rgb(69, 77, 85); font-size:13px;">
															<i class="fas fa-ban text-white" style="font-size:13px;"></i>
														</button>
													</form>
													
													<c:forEach items="${voie.listeLongueurs}" var="longueur">
														<form action="<c:url value="/deletevoieorlongueurorsecteur?longueurId=${longueur.id}&siteId=${site.id}" />" method="post">
															<button type="submit" name="moins" class="border-0" style="background-color:rgb(69, 77, 85); font-size:13px;">
																<i class="fas fa-ban text-white" style="font-size:13px;"></i>
															</button>
														</form>
													</c:forEach>
													<br/>
												</c:forEach>													
											</td>
										</tr>
									</table>
									<div class="btn-group">
										<button class="btn btn-primary mt-2" type="button" data-toggle="collapse" data-target="#collapse${secteur.id}"
											>Ajouter une voie</button>
										<button class="btn btn-primary  mt-2" type="button" data-toggle="collapse" data-target="#collapse2${secteur.id}"
										>Ajouter une longueur</button>
									</div>
									<form action="<c:url value="/ajoutervoie?siteId=${site.id}&secteurId=${secteur.id}" />" method="post">
										<div class="collapse form-group mt-2" id="collapse${secteur.id}">
											<select name="cotation" class="form-control">
												<option value="">Cotation</option>
												<c:choose>
													<c:when test="${not empty secteur.listeVoies[0].cotationBloc}">													
														<c:forEach items="${listeCotationBloc}" var="cotationBloc">
															<option value="${cotationBloc.valeurCotation}">${cotationBloc.valeurCotation}</option>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach items="${listeCotationFalaise}" var="cotationFalaise">
															<option value="${cotationFalaise.valeurCotation}">${cotationFalaise.valeurCotation}</option>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</select>
											<div class="form-group mt-2">
												<label for="isEquipe">La voie est-elle équipée ?</label> 
												<input type="checkbox" name="isEquipe">
											</div>
											<button class="btn btn-primary  mt-2" type="submit">Ajouter</button>
										</div>
									</form>
									<form action="<c:url value="ajouterlongueur?siteId=${site.id}&secteurId=${secteur.id}" />" method="post">
										<div class="collapse form-group mt-2" id="collapse2${secteur.id}">
											<select name="cotation" class="form-control">
												<option value="">Cotation</option>
												<c:choose>
													<c:when test="${not empty secteur.listeVoies[0].cotationBloc}">													
														<c:forEach items="${listeCotationBloc}" var="cotationBloc">
															<option value="${cotationBloc.valeurCotation}">${cotationBloc.valeurCotation}</option>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach items="${listeCotationFalaise}" var="cotationFalaise">
															<option value="${cotationFalaise.valeurCotation}">${cotationFalaise.valeurCotation}</option>
														</c:forEach>
													</c:otherwise>
												</c:choose>
												</select>
												<select name="voieId" class="form-control">
													<option value="">Voie</option>
												<c:forEach items="${secteur.listeVoies}" var="voie">
														<option value="${voie.id}">${voie.id}</option>
												</c:forEach>
											</select>
											<button class="btn btn-primary mt-2" type="submit">Ajouter</button>
										</div>
									</form>
								</td>
								<td>
									<form action="<c:url value="/deletevoieorlongueurorsecteur?secteurId=${secteur.id}&siteId=${site.id}" />" method="post">
										<button type="submit" name="moins" class="border-0">
											<i class="fas fa-ban fa-4x"></i>
										</button>
									</form>
								</td>
			        </tr>
		        </c:forEach>
		      </tbody>
		    </table>
		   </div>
			</c:if>
			<button class="btn btn-primary btn-lg" type="button" data-toggle="collapse" data-target="#collapse">
				<i class="fas fa-plus"></i><br>Ajouter un secteur</button>
				
			<form class="form-inline my-3" action="<c:url value="createsecteur?siteId=${site.id}" />"
				method="post">
				<div class="collapse form-group mr-2" id="collapse">		
					<input class="form-control" type="text" placeholder="Nom" name="nomSecteur" required>
					<button class="btn btn-primary ml-2" type="submit"> Ajouter </button> <br/>
				</div>
			</form>
		</div>
	</section>
	
	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>

</body>

</html>