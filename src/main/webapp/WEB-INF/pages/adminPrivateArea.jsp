<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет админа</title>
</head>
<body>
<a href="/logAdmin/country">Country</a>
<br>
<a href="/logAdmin/city">City</a>
<br>
<a href="/logAdmin/company">Company</a>
<br>
<a href="/logAdmin/aircraft">Aircraft</a>
<br>
<a href="/logAdmin/classPlace">ClassPlace</a>
<br>
<a href="/logAdmin/place">Place</a>
<br>
<a href="/logAdmin/flight">Flight</a>
<br>
<a href="/logAdmin/removeCity">Remove City</a>
<br>

<a href="localhost:8080/">Выход</a>
<c:forEach var="pass" items="${listPassenger}">
    <c:out value="${pass}"/>
    <br>
</c:forEach>
</body>
</html>
