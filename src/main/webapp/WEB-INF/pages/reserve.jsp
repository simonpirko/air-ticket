<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Бронирование</title>
</head>
<body>
    <form method="post" action="/logPass/reserve">
        <p>Откуда</p>
        <input name="cityFrom">
        <p>Куда</p>
        <input name="cityTo">
        <p>Место какого класса</p>
        <button type="submit">Забронировать</button>
    </form>

    ${errorReservePlace}

    <a href="/logPass">Вернуться</a>

<c:forEach var="flight" items="${listFlights}">
    <p>Откуда: <c:out value="${flight.getCityFrom().getNameCity()}"/></p> <p> Куда: <c:out value="${flight.getCityTo().getNameCity()}"/></p><p> Когда:  <c:out value="${flight.getFlightDate()}"/></p>
    <br>
</c:forEach>
</body>
</html>
