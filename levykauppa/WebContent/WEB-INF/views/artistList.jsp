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

<ul>
    <c:forEach items="${ artists }" var="artist">
        <li>
            <a href="/levykauppa/Artistid?id=${ artist.getId() }">
                <c:out value="${ artist.getName() }" />
            </a>
        </li>
    </c:forEach>
</ul>

</body>
</html>