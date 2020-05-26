<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des topos</title>
	<style type="text/css"><%@ include file="/style/style2.css" %></style>

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>	
	<div class="container">
		<%@ include file="/WEB-INF/common/header.jspf" %>
	</div>
	
	<div class="container sticky-top">
			<%@ include file="/WEB-INF/common/navigation.jspf" %>
	</div>
	
	<section>
		<div class="container bg-white mt-5 mb-5 border">
			<h1>Description du site</h1>
		
			<!-- description du site -->
			<p>Nom: ${site.nom} <br/>
			Certification: ${site.isOfficielLesAmisDeLescalade} </p>
			
			<!-- pour ajouter un nouveau commentaire -->
			<p><a href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=null&isEditing=false"/>">
			Poster un commentaire</a></p>
			
			<h2>Commentaires:</h2>
			<ul>
				<c:forEach items="${listecommentaires}" var="commentaire">
					<li> 
						<!-- affichage des commentaires parent -->
						<p> 
							Posté par ${commentaire.utilisateur.prenom} 
							${commentaire.utilisateur.nom} :
						</p>
						<div class="container">
							<div class="row">
				        		<div class="col-8 border text-break mb-3 p-3">
									<p>${commentaire.contenu}</p>
								</div>
								<div class ="col-4">
									<!-- pour répondre après un commentaire et ses potentielles réponses -->
			        				<p><a href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=${commentaire.id}&isEditing=false"/>">
			        				Répondre à ce commentaire
			        				</a></p>
			        				<!-- suppression ou édition d'un commentaire par un admin -->
			        				<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
										<form action="<c:url value="details-site?siteId=${site.id}&commentaireId=${commentaire.id}"/>" method="POST">
											<input type="submit" value="Supprimer ce commentaire"/>
										</form>
					        			<p><a class="text-danger" 
					        				href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=${commentaire.id}&isEditing=true"/>">
					        				Editer ce commentaire</a></p>
			        				</c:if>
			        			</div>
			        		</div>
			        		
			        		<!-- affichage des réponses aux commentaires parents -->
			        		<c:forEach items="${listerepcommentaires}" var="repcommentaire">
			        			<c:if test="${repcommentaire.commentaireParent.id == commentaire.id}">
			        				<div class="collapse row" id="collapse${commentaire.id}">
					        			<div class="col-8 border text-break mb-3 ml-5 p-3">
					        				<p>
					        				Posté par ${repcommentaire.utilisateur.prenom} 
												${repcommentaire.utilisateur.nom} :
					        				${repcommentaire.contenu}</p>
					        				<!-- suppression ou édition d'un commentaire par un admin -->
					        				<c:if test="${sessionScope.sessionUtilisateur.isMembreAssociation == true}">
							        			<form action="<c:url value="details-site?siteId=${site.id}&commentaireId=${repcommentaire.id}"/>" method="POST">
													<input type="submit" value="Supprimer ce commentaire"/>
												</form>
							        			<p><a class="text-danger" href="<c:url value="postercommentaire?siteId=${site.id}&commentaireId=${repcommentaire.id}&isEditing=true"/>">
							        			Editer ce commentaire</a></p>
					        				</c:if>
					        			</div>
				        			</div>
			        			</c:if>
			        		</c:forEach>
				        </div>
				        	<!-- pour pouvoir afficher ou masquer les réponses d'un commentaire -->
				        	<c:if test="${!empty listerepcommentaires}">
				        		<div class="mb-3">
						        	<a data-toggle="collapse" href="#collapse${commentaire.id}" 
										 aria-expanded="false" aria-controls="collapse${commentaire.id}">
										 Afficher les réponses </a>
								</div>
				        	</c:if>
			        </li>
				</c:forEach>
			</ul>
		</div>
	</section>

	<div class="container">
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
</body>
</html>