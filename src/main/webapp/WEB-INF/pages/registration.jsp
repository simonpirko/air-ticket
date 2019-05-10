<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Регистрация</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/reg/admin">Регистрация для администратора</a>
    <a href="${pageContext.request.contextPath}/reg/passenger">Регистрация для пассажира</a>
</body>
</html>
