<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 27.11.2019
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="pd4ml" uri="http://pd4ml.com/tlds/4.0" %>
<html>
<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal"/>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <pd4ml:transform
                screenWidth="1000"
                pageFormat="A4"
                pageOrientation="portrait"
                pageInsets="15,15,25,15,points"
                inline="true"
                fileName="reservation.pdf">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>reservation.pdf</title>
                <link href="<c:url value="/bootstrap.min.css"/>" rel="stylesheet">
            </head>
            <body>
            <div class="container">
                <h2 align="center">Reservation list</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="row">ReservationId</th>
                        <th scope="row">Start_date</th>
                        <th scope="row">Final_date</th>
                        <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
                            <th scope="row">User</th>
                        </sec:authorize>
                        <th scope="row">Apartment</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${reservation_list }" var="reservation">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <sec:authorize access="!hasRole('ROLE_SUPERADMIN')">
                                <c:forEach items="${employee_list }" var="employee">
                                    <c:if test="${reservation.user_id eq employee.employeeId}">
                                        <c:if test="${principal.username eq employee.passportId}">
                                            <tr>
                                                <td>${reservation.id }</td>
                                                <td>${reservation.start_date }</td>
                                                <td>${reservation.final_date}</td>
                                                <td>${reservation.room }</td>
                                            </tr>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </sec:authorize>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
                            <tr>
                                <td>${reservation.id }</td>
                                <td>${reservation.start_date }</td>
                                <td>${reservation.final_date}</td>
                                <c:forEach items="${employee_list }" var="employee">
                                    <c:if test="${employee.employeeId eq reservation.user_id}">
                                        <td><p>${reservation.user_id } ${employee.lastName} ${employee.firstName}
                                            [phone:${employee.phone}]</p></td>
                                    </c:if>
                                </c:forEach>
                                <td>${reservation.room }</td>
                            </tr>
                        </sec:authorize>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div align="right">${date}</div>
            </body>
        </pd4ml:transform>
    </sec:authorize>
</sec:authorize>
</html>