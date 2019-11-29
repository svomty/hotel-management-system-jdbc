<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 27.11.2019
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="pd4ml" uri="http://pd4ml.com/tlds/4.0" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal"/>
    <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
        <pd4ml:transform
                screenWidth="1000"
                pageFormat="A4"
                pageOrientation="portrait"
                pageInsets="15,15,25,15,points"
                inline="true"
                fileName="zaseleniye.pdf">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>zaseleniye.pdf</title>
                <style>
                    <%@ include file="/WEB-INF/css/bootstrap.min.css" %>"/>
                </style>
            </head>
            <body>
            <div class="container">
                <h2 align="center">Zaseleniye list</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="row">ZaseleniyeId</th>
                        <th scope="row">Start_date</th>
                        <th scope="row">Final_date</th>
                        <th scope="row">Client</th>
                        <th scope="row">Apartment</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${zaseleniye_list }" var="zaseleniye">
                        <tr>
                            <td>${zaseleniye.id }</td>
                            <td>${zaseleniye.start_date }</td>
                            <td>${zaseleniye.final_date}</td>
                            <c:forEach items="${employee_list }" var="employee">
                                <c:if test="${employee.employeeId eq zaseleniye.user_id}">
                                    <td><p>${zaseleniye.user_id } ${employee.lastName} ${employee.firstName}
                                        [phone:${employee.phone}]</p></td>
                                </c:if>
                            </c:forEach>
                            <td>${zaseleniye.room }</td>
                        </tr>
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
