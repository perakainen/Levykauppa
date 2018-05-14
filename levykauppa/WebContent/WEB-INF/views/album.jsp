<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<h1><c:out value="${ album.getTitle() }" /></h1>

<ul>
<c:forEach items="${ tracks }" var="track">
    <li>
        <c:out value="${ track.getName() }" />
    </li>
</c:forEach>
</ul>


</body>
</html>