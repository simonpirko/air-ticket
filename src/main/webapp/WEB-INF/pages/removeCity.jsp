<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Удаление города</title>
</head>
<body>
    <spring:form modelAttribute="removeCity" method="post" action="/logAdmin/removeCity">
        <spring:input path="nameCity"/>
        <spring:errors path="nameCity"/>
        <spring:button>Удалить</spring:button>
    </spring:form>

    <a href="/logAdmin">Вернуться</a>
</body>
</html>
