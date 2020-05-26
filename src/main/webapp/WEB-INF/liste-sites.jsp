<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css"><%@ include file="/style/style2.css" %></style>
	<title>Liste des Sites</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	 integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<%@ include file="/WEB-INF/common/header.jspf" %>
		<%@ include file="/WEB-INF/common/navigation.jspf" %>
	</div>
	
	<section>
	    <div class="container jumbotron bg-white mt-5 border">
			<h1 class="mb-5">Liste des Sites</h1>
			<div class="card-deck" >
				<c:forEach items="${listeDesSites}" var="site">
					<div class="card">
		                <div class="card-header">
		                	<h2 class="card-title"><a href="<c:url value="details-site?id=${site.id}"/>">${site.nom}</a></h2>
		                </div>
		                <div class="card-body">
		                	<p class="card-text">Courte présentation</p>
		                </div>
		        	 </div>
				</c:forEach>
			 </div>
		</div>
	</section>
	
	
	<div class="container">
      <%@ include file="/WEB-INF/common/footer.jspf" %>
    </div>
	
</body>
</html>