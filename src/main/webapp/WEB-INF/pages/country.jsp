<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Добавление государства</title>
</head>
<body>
    <spring:form modelAttribute="newCountry" method="post" action="/logAdmin/country">
        <p>Страна</p>
        <spring:input path="nameCountry"/>
        <spring:errors path="nameCountry"/>
        ${error}
        <p>Краткое название</p>
        <spring:input path="shortName"/>
        <spring:errors path="shortName"/>
        <spring:button>Добавить страну</spring:button>
    </spring:form>

    <a href="/logAdmin">Вернуться</a>
</body>
</html>
