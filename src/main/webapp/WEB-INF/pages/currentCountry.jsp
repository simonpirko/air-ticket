<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текущая страна</title>
</head>
<body>
    <spring:form action="/logAdmin/currentCountry" modelAttribute="currentCountry" method="post">
        <spring:input path="nameCountry"/>
        <spring:button>Выбрать текущее государство</spring:button>
        ${errorPickCountry}
        <spring:errors path="nameCountry"/>
    </spring:form>
</body>
</html>
