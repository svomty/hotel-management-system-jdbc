<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 17.11.2019
  Time: 6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Заселенные в гостиницу</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Список забронированных номеров</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="row">Id заселения</th>
            <th scope="row">Дата приезда</th>
            <th scope="row">Дата отъезда</th>
            <th scope="row">Клиент</th>
            <th scope="row">Апартамент</th>
            <th scope="row">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservation_list }" var="reservation">
            <tr>
                <td>${reservation.id }</td>
                <td>${reservation.start_date }</td>
                <td>${reservation.final_date}</td>
                <td>${reservation.user_id }</td>
                <td>${reservation.room }</td>

                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="principal" property="principal"/>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <c:forEach items="${employee_list }" var="employee">
                            <c:if test="${reservation.user_id eq employee.employeeId}">
                                <c:if test="${principal.username eq employee.passportId}">
                                    <td>
                                        <spring:url value="/protected/reservation/delete/${reservation.id }"
                                                    var="deleteURL"/>
                                        <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                                    </td>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
                        <td>
                            <spring:url value="/protected/reservation/delete/${reservation.id }" var="deleteURL"/>
                            <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                        </td>
                    </sec:authorize>
                </sec:authorize>


            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/protected/reservation/add" var="addURL"/>
    <a class="btn btn-success" href="${addURL }" role="button">Забронировать место</a>
    <spring:url value="/" var="link"/>
    <a class="btn btn-danger" href="${link}" role="button" style="float: right;">Главное меню</a>
</div>
</body>
</html>
