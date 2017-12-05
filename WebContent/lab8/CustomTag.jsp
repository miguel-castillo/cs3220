<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="lab8" uri="http://cs.calstatela.edu/cs3220stu44/lab8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab 8</title>
</head>
<body>

<p>This is the result of the IntToWordTag
	<lab8:intToWord integer="127"/>
</p>

<p> Enter a number from 1-999 </p>
<form action="CustomTag.jsp">
	<input type="text" name="integer"><br>
	<input type="submit" value="Submit">
</form>


<c:if test="${not empty param.integer}">
  <p> <%= request.getParameter("integer") %> in word form is <lab8:intToWord integer="<%= request.getParameter(\"integer\") %>"/> </p>
</c:if>


</body>
</html>