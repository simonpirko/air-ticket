<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Страница пассажира</title>
</head>
<body>
    <p>Добро пожаловать, ${currentPass.getFirstName()}</p>
    <a href="${pageContext.request.contextPath}/logPass/pa">Личный кабинет</a>
    <a href="/logPass/reserve">Бронирование</a>
    <a href="localhost:8080/">Выход</a>

    ${currentFlight.getCityFrom().getNameCity()}
    ${currentFlight.getCityTo().getNameCity()}
</body>
</html>
