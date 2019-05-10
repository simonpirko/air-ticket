<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Регистрация пассажира</title>
</head>
<body>
    <spring:form method="post" action="/reg/passenger" modelAttribute="newPassenger">
        <p>Имя</p>
        <spring:input path="firstName"/>
        <spring:errors path="firstName"/>
        <p>Фамилия</p>
        <spring:input path="secondName"/>
        <spring:errors path="secondName"/>
        <p>Логин</p>
        <spring:input path="login"/>
        <spring:errors path="login"/>
        ${messageErrorPassenger}
        <p>Пароль</p>
        <spring:input type="password" path="password"/>
        <spring:errors path="password"/>
        <p>Номер паспорта</p>
        <spring:input path="documentNumber"/>
        <spring:errors path="documentNumber"/>
        <spring:button>Зарегистрироваться</spring:button>
    </spring:form>
</body>
</html>
