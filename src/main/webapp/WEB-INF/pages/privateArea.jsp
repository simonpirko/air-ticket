<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Личный кабинет</title>
</head>
<body>
<spring:form action="/logPass/pa" modelAttribute="pass" method="post">
    <spring:hidden path="id" value="${pass.id}"/>
    <spring:hidden path="login" value="${pass.login}"/>
    <spring:hidden path="password" value="${pass.password}"/>
    <p>Имя</p>
    <spring:input path="firstName" value="${pass.firstName}"/>
    <p>Фамилия</p>
    <spring:input path="secondName" value="${pass.secondName}"/>
    <p>Паспорт</p>
    <spring:input path="documentNumber" value="${pass.documentNumber}"/>
    <spring:button>Изменить значения</spring:button>
</spring:form>
</body>
</html>
