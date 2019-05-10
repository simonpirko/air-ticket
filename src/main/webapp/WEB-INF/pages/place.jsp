<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Добавление места</title>
</head>
<body>
    <spring:form action="/logAdmin/place" modelAttribute="newPlace" method="post">
        <p>Номер места</p>
        <spring:input path="seat"/>
        <spring:errors path="seat"/>
        <spring:button>Добавить место</spring:button>
    </spring:form>
    ${errorAddPlace}

    <a href="/logAdmin/currentPlaceClass">Выбрать текущий класс места</a>
    <a href="/logAdmin">Вернуться</a>
</body>
</html>
