<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Добавление компании</title>
</head>
<body>
    <spring:form method="post" modelAttribute="newCompany" action="/logAdmin/company">
        <p>Введите название компании</p>
        <spring:input path="nameCompany"/>
        <spring:button>Добавить компанию</spring:button>
        <spring:errors path="nameCompany"/>
        ${error}
    </spring:form>
    <a href="/logAdmin">Вернуться</a>
</body>
</html>
