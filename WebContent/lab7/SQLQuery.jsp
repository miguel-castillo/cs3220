<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource
	var="snapshot"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu44"
	user="cs3220stu44"
	password="PPVNV*YS"
/>

<%-- query --%>
<c:choose>
	<c:when test="${not empty param.sql}">
	<sql:query dataSource="${snapshot}" var="items" >
	${param.sql}
	</sql:query>
	</c:when>
</c:choose>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Query</title>
</head>

<body>
	<div class="container">
	
	<div class="page-header">
		<h3>SQL Query</h3>	
	</div>
	
	<div class="well">
	<form action="SQLQuery.jsp" method="post">
			<div class="form-group">
				<textarea class="form-control" rows="5" name="sql"></textarea>
			</div>
			<div class="text-center">
				<input class="btn btn-primary" type="submit" name="submit" value="Execute Query">
			</div>
		</form>
	</div>
	
		<c:choose>
	<c:when test="not empty param.sql">
		<table class="table table-striped table-bordered table-hover">
	<c:forEach items="${items.rows}" var="row">
		<c:forEach items="${row}" var="col">
			<tr>
				<td>${col.key}</td><td>${col.value}</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>
	</c:when>
</c:choose>

	
	</div>

</body>
</html>