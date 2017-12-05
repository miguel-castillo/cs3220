<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="simpsons.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>${character.characterName } Profile</title>
</head>
<body>
	<c:choose>
		<c:when test="${character.numberOfPictures == 0}">
			<p class="lead">No images are available for ${character.characterName }</p>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div class="row">
					<div class="col-sm-offset-3 col-sm-6">
						<div class="well text-center">
							<img style="width: 30%;"
								src="http://albertcervantes.com/cs3220/cdn/simpsons/simpsons.png">
							<h2>${character.characterName}</h2>
							<p class="lead">Displaying 1 of ${character.numberOfPictures} images.</p>
							<p>
								<a class="btn btn-success" href="CharacterCatalog"> Catalog </a> <a
									class="btn btn-success" href="CharacterProfile?id=${param.id }"> Next
									Image </a>
							</p>
							<p class="text-center" style="overflow: none;">
								<a href="CharacterProfile?id=${character.id}">
								<c:set var="nameToLower" value="${fn:toLowerCase(character.characterName)}" />
								<c:set var="name" value="${fn:replace(nameToLower, ' ', '_')}" />
								<img style="max-height: 200px;" 
								src="http://albertcervantes.com/cs3220/cdn/simpsons/${name}/pic_${pic}.jpg">
								</a>
							</p>
		
						</div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>	
</body>
</html>