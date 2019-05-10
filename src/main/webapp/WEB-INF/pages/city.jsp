<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление города</title>
</head>
<body>
<div>
    <p>Добавление города</p>
    <spring:form method="post" action="/logAdmin/city" modelAttribute="newCity">
        <p>Введите название города</p>
        <spring:input path="nameCity"/>
        <spring:errors path="nameCity"/>
        <spring:button>Добавить город</spring:button>
        ${errorCurrentCountry}
    </spring:form>
</div>
<a href="/logAdmin/currentCountry">Выбрать государство</a>
<a href="/logAdmin">Вернуться</a>

</body>
</html>
