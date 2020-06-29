<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Description site</title>
<style type="text/css"><%@include file="/style/style2.css"%></style>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
<script src="https://kit.fontawesome.com/56a2cfb089.js" crossorigin="anonymous"></script>
</head>
<body class="bg-light">
	<div>
		<%@ include file="/WEB-INF/common/navigation.jspf"%>
	</div>
	<section class="container ">
		<h1 class="text-center jumbotron p-4">Détails du site</h1>
		<div class="jumbotron bg-white mt-5 mb-5 border min-vh-100">
			
			<!-- Description du site -->
			<h3 class="mb-4">Description du site:</h3>
			<div class="row">
				<div class="col-8">
					<ul class="list-group col-6">
		       <li class="list-group-item"><span class="font-weight-bold">Nom:</span> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; ${site.nom}</li>
		       <li class="list-group-item"><span class="font-weight-bold">Département:</span> &emsp;&emsp; ${site.departement.valeurDepartement}</li>
		       <li class="list-group-item"><span class="font-weight-bold">Certification:</span> &emsp;&emsp;&ensp;
		       <c:choose >
			       	<c:when test="${ site.isOfficielLesAmisDeLescalade == true }">
			       		Oui
			       	</c:when>
			       	<c:otherwise>
			       		Non
			       	</c:otherwise>	       
		       </c:choose>
		       </li>
		       <li class="list-group-item"><span class="font-weight-bold">Type de cotation:</span> &ensp;
		       	<c:choose>
							<c:when test="${(not empty site.listeVoies[0].cotationBloc) or (not empty site.listeSecteurs[0].listeVoies[0].cotationBloc)}">
								Cotation Bloc
							</c:when>
							<c:otherwise>
								Cotation Falaise
							</c:otherwise>
						</c:choose>
		       </li>
		     	</ul>
		     	<br/>
		     	<p> ${site.description} </p>
	     	</div>
	     	
	     	<!-- liste des cotations (voies et longueurs) du site si il n'a pas de secteur -->
	     	<c:if test="${empty site.listeSecteurs}">
	     		<div class="table-responsive col-4">
						<table class="table table-bordered">
						<thead>
							<tr>
								<th>Id voie</th>
								<th>Cotation</th>
								<th>Est équipé</th>
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
							</tr>
						</table>
					</div>
				</c:if>
			</div>
			
			<!-- Présentation des secteurs -->
			<c:if test="${not empty site.listeSecteurs}">
				<!-- Description -->
				<h3 class="my-4">Description des secteurs:</h3>
				<div class="row">
				  <div class="col-4">
				    <div class="list-group" id="list-tab" role="tablist">
				    	<c:forEach items="${site.listeSecteurs}" var="secteur" varStatus="status">
				    		<c:choose>
				    			<c:when test="${status.index == 0}">
				    				<a class="list-group-item list-group-item-action active" id="nom-${secteur.id}" data-toggle="list" 
				    				href="#description-${secteur.id}" role="tab" aria-controls="nom-${secteur.id}">${secteur.nom}</a>
				    			</c:when>
				    			<c:otherwise>
				    				<a class="list-group-item list-group-item-action" id="nom-${secteur.id}" data-toggle="list" 
				    					href="#description-${secteur.id}" role="tab" aria-controls="nom-${secteur.id}">${secteur.nom}</a>
				    			</c:otherwise>
				    		</c:choose>
				    	</c:forEach>
				    </div>
				  </div>
				  <div class="col-8">
				    <div class="tab-content" id="nav-tabContent">
				    	<c:forEach items="${site.listeSecteurs}" var="secteur" varStatus="status">
					    	<c:choose>
					    		<c:when test="${status.index == 0}">
							      <div class="tab-pane fade active show" id="description-${secteur.id}" role="tabpanel" 
							      	aria-labelledby="nom-${secteur.id}">
							      	
												<p>${secteur.description}</p>
							      	
							      	<!-- liste des cotations (voies et longueurs) des différents secteurs -->
								     		<div class="table-responsive">
													<table class="table table-bordered">
													<thead>
														<tr>
															<th>Id voie</th>
															<th>Cotation</th>
															<th>Est équipé</th>
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
																	<c:when test="${not empty site.listeVoies[0].cotationBloc}">
																		<c:forEach items="${site.listeVoies}" var="voie">
																			${voie.cotationBloc.valeurCotation} <br/>
																			<c:forEach items="${voie.listeLongueurs}" var="longueur">
																				&ensp;&ensp;${longueur.cotationBloc.valeurCotation} <br/>
																			</c:forEach>
																			<br/>
																		</c:forEach>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${site.listeVoies}" var="voie">
																			${voie.cotationFalaise.valeurCotation} <br/>
																			<c:forEach items="${voie.listeLongueurs}" var="longueur">
																				&ensp;&ensp;${longueur.cotationFalaise.valeurCotation} <br/>
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
														</tr>
													</table>
												</div>
							      </div>
							    </c:when>
							    <c:otherwise>
							    	<div class="tab-pane fade" id="description-${secteur.id}" role="tabpanel" 
							      	aria-labelledby="nom-${secteur.id}">
												<p>${secteur.description}</p>
							      	
								     		<div class="table-responsive">
													<table class="table table-bordered">
													<thead>
														<tr>
															<th>Id voie</th>
															<th>Cotation</th>
															<th>Est équipé</th>
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
																	<c:when test="${not empty site.listeVoies[0].cotationBloc}">
																		<c:forEach items="${site.listeVoies}" var="voie">
																			${voie.cotationBloc.valeurCotation} <br/>
																			<c:forEach items="${voie.listeLongueurs}" var="longueur">
																				&ensp;&ensp;${longueur.cotationBloc.valeurCotation} <br/>
																			</c:forEach>
																			<br/>
																		</c:forEach>
																	</c:when>
																	<c:otherwise>
																		<c:forEach items="${site.listeVoies}" var="voie">
																			${voie.cotationFalaise.valeurCotation} <br/>
																			<c:forEach items="${voie.listeLongueurs}" var="longueur">
																				&ensp;&ensp;${longueur.cotationFalaise.valeurCotation} <br/>
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
														</tr>
													</table>
												</div>
										</div>
							    </c:otherwise>
							  </c:choose>
						  </c:forEach>
				    </div>
				  </div>
				</div>
			</c:if>
			
			<!-- pour ajouter un nouveau commentaire -->
			<div class="mt-5">
				<a href="<c:url value="poster-commentaire?siteId=${site.id}&commentaireId=null&isEditing=false"/>">
					<button class="btn btn-dark btn-lg"><i class="fa fa-comment"></i><br>Commenter</button>
				</a>	
				<a class="ml-3" href="<c:url value="modifierinformations?siteId=${site.id}"/>">
					<button class="btn btn-primary btn-lg"><i class="fa fa-pencil"></i><br>Modifier informations</button>
				</a>
			</div>
			
			<div class="jumbotron mt-5">
				<h3>Commentaires:</h3>
				
				<ul>
					<c:forEach items="${listecommentaires}" var="commentaire">
						<li>
							<!-- affichage des commentaires parent -->
							<p>Posté par ${commentaire.utilisateur.prenom} ${commentaire.utilisateur.nom} :</p>
							<div class="container">
								<div class="row">
									<div class="col-8 border border-secondary text-break mb-3 p-3">
										<p>${commentaire.contenu}</p>
									</div>
									<div class="col-4">
										<!-- pour répondre après un commentaire et ses potentielles réponses -->
										<p>
											<a href="<c:url value="poster-commentaire?siteId=${site.id}&commentaireId=${commentaire.id}&isEditing=false"/>">
												Répondre à ce commentaire </a>
										</p>
										<!-- suppression ou édition d'un commentaire par un admin -->
										<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
											<p>
												<a class="text-danger"
													href="<c:url value="supprimer-commentaire?siteId=${site.id}&commentaireId=${commentaire.id}"/>">
													Supprimer ce commentaire</a>
											</p>
											<p>
												<a class="text-danger"
													href="<c:url value="poster-commentaire?siteId=${site.id}&commentaireId=${commentaire.id}&isEditing=true"/>">
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
											<div class="col-8 border border-secondary text-break mb-3 ml-5 p-3">
												<p>${repcommentaire.contenu}</p>
											</div>
											<div class="col-3">
												<!-- suppression ou édition d'un commentaire par un admin -->
												<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
													<p>
														<a class="text-danger"
															href="<c:url value="supprimer-commentaire?siteId=${site.id}&commentaireId=${repcommentaire.id}"/>">
															Supprimer ce commentaire</a>
													</p>
													<p>
														<a class="text-danger"
															href="<c:url value="poster-commentaire?siteId=${site.id}&commentaireId=${repcommentaire.id}&isEditing=true"/>">
															Editer ce commentaire</a>
													</p>
												</c:if>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</div> 
							<!-- pour pouvoir afficher ou masquer les réponses d'un commentaire --> 
							<c:if test="${!empty commentaire.listeReponses}">
								<div class="mb-3">
									<a data-toggle="collapse" href="#collapse${commentaire.id}" aria-expanded="false"
										aria-controls="collapse${commentaire.id}"> Afficher les réponses </a>
								</div>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</section>

	<div>
		<%@ include file="/WEB-INF/common/footer.jspf"%>
	</div>
</body>
</html>