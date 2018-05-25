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
<h1>Etusivu</h1>
<h2>Levykauppa</h2>
<form action="/levykauppa/Artist" method="post">
	<button type ="submit" name="takaisin"  formmethod="post">Listaa Artistit</button>
</form>
<form action="/levykauppa/Artistnew">
	<button type ="submit" value="Listaa Artistit" >Lisää Artisti</button>
</form>
</body>
</html>