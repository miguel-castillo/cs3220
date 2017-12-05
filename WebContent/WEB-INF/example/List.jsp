<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Reddit Links</title>
</head>
<body>
<h1>The True Reddit</h1>
	<div class="jumbotron">
		<div class="container">
			<a href="Add">Add Link</a>
				<div class="link">
					<table>
						<c:forEach items="${links}" var="link">
							<tr>
								<td><h3>${link.title}</h3></td>
								<td><a>${link.link}</a></td>
								<td><span class="count">${link.vote}</span></td>
								<a class="btn btn-danger" href="UpController?id=${row.id}" role="button">UpVote</a>
								<a class="btn btn-danger" href="DownController?id=${row.id}" role="button">DownVote</a>
							</tr>
						</c:forEach>
					</table>
					<span class="count"></span>
				</div>
		</div>
	</div>	

</body>
</html>