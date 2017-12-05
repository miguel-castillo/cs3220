<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="simpsons.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simpson's Catalog</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<img style="width: 30%;"
				src="http://albertcervantes.com/cs3220/cdn/simpsons/simpsons.png"
				alt="">
			<h1>Character Catalog</h1>
			<p class="lead">Click on an image below to view a random image of
				your favorite character!</p>
				
				
			<div class="row">
			<c:forEach items="${characters}" var="character">
				<div class="col-sm-4 text-center">
					<div class="well">
						<a href="CharacterProfile?id=${character.id}">
						<c:choose>
							<c:when test="${character.numberOfPictures == 0 }">
								<img style="height: 150px;" src="http://via.placeholder.com/150?text=N/A" class="img-responsive img-thumbnail" alt="${character.characterName}">
								<h4 class="text-center">${character.characterName}</h4>
							</c:when>
							<c:otherwise>
								<c:set var="nameToLower" value="${fn:toLowerCase(character.characterName)}" />
								<c:set var="name" value="${fn:replace(nameToLower, ' ', '_')}" />
								<img style="height: 150px;" src="http://albertcervantes.com/cs3220/cdn/simpsons/${name}/pic_0001.jpg" class="img-responsive img-thumbnail" alt="${character.characterName}">
								<h4 class="text-center">${character.characterName}</h4>
							</c:otherwise>
						</c:choose>
						</a>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>