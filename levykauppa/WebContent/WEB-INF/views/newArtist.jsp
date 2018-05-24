<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Luo uusi artisti</h1>

<c:if test="${error != null }">
	<p>Error: <c:out value="${ error }"/></p>
</c:if>

<form action="/Artistnew" method="get"  >
	<label>
    	Name: <input name="artistName" />
    </label>
    <input type="submit" value="Save" />
    
</form>

</body>
</html>