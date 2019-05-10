<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Вход для пассажира</title>
</head>
<body>
    <spring:form method="post" modelAttribute="checkPassenger" action="/log/passenger">
        ${errorLogin}
        <p>Логин</p>
        <spring:input path="login"/>
        <spring:errors path="login"/>
        <p>Пароль</p>
        <spring:input type="password" path="password"/>
        <spring:errors path="password"/>
        <spring:button>Войти</spring:button>
    </spring:form>
</body>
</html>
