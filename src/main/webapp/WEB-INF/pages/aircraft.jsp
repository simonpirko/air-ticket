<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление самолета</title>
</head>
<body>
    <spring:form method="post" modelAttribute="newAir" action="/logAdmin/aircraft">
        <p>Введите название самолета</p>
        <spring:input path="nameAircraft"/>
        <spring:button>Добавить самолет</spring:button>
        <spring:errors path="nameAircraft"/>
        ${errorCurrentCompany}
    </spring:form>
    <a href="/logAdmin/currentCompany">Выбрать компанию</a>
    <a href="/logAdmin">Вернуться</a>
</body>
</html>
