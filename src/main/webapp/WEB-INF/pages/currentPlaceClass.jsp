<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form modelAttribute="currentPlaceClass" method="post" action="/logAdmin/currentPlaceClass">
        <spring:input path="name"/>
        <spring:button>Выбрать класс места</spring:button>
        <spring:errors path="name"/>
        ${errorPlaceClass}
    </spring:form>
</body>
</html>
