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
    <title>Hotel Reservation List</title>
    <link href="<c:url value="/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <td><h2>List of booked rooms</h2></td>
            <td>
                <div align="right">
                    <form action="/reports/reservation">
                        <button style="width:100%;" class="btn btn-dark" type="submit">Make report</button>
                    </form>
                </div>
            </td>
        </tr>
    </table>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="row">Id Check In</th>
            <th scope="row">Start date</th>
            <th scope="row">Final date</th>
            <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
                <th scope="row">User</th>
            </sec:authorize>
            <th scope="row">Apartment</th>
            <th scope="row">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservation_list }" var="reservation">
            <tr>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="principal" property="principal"/>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <c:forEach items="${employee_list }" var="employee">
                            <c:if test="${reservation.user_id eq employee.employeeId}">
                                <c:if test="${principal.username eq employee.passportId}">
                                    <td>${reservation.id }</td>
                                    <td>${reservation.start_date }</td>
                                    <td>${reservation.final_date}</td>
                                    <td>${reservation.room }</td>
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
                        <td>${reservation.id }</td>
                        <td>${reservation.start_date }</td>
                        <td>${reservation.final_date}</td>
                        <td>${reservation.user_id }</td>
                        <td>${reservation.room }</td>
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
    <a class="btn btn-success" href="${addURL }" role="button">Add hotel reservation</a>
    <spring:url value="/" var="link"/>
    <a class="btn btn-danger" href="${link}" role="button" style="float: right;">Main menu</a>
</div>
</body>
</html>
