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
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Checked into the hotel list</title>
    <link href="<c:url value="/bootstrap.min.css"/>" rel="stylesheet">
    <style>
        [data-tooltip]::after {
            content: attr(data-tooltip); /* Выводим текст */
            opacity: 0;
            transition: 1s;
            pointer-events: none;
        }

        [data-tooltip]:hover::after {
            opacity: 1;
        }
    </style>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <td><h2>Checked into the hotel list</h2></td>
            <td>
                <div align="right">
                    <form action="/reports/zaseleniye">
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
            <th scope="row">User</th>
            <th scope="row">Apartment</th>
            <th scope="row">Delete</th>
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
                        <td><p data-tooltip="${employee.lastName} ${employee.firstName}">${zaseleniye.user_id }</p></td>
                    </c:if>
                </c:forEach>
                <td>${zaseleniye.room }</td>
                <td>
                    <spring:url value="/confidential/zaseleniye/delete/${zaseleniye.id }" var="deleteURL"/>
                    <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/confidential/zaseleniye/add" var="addURL"/>
    <a class="btn btn-success" href="${addURL }" role="button">Check in a guest at the hotel</a>
    <spring:url value="/" var="link"/>
    <a class="btn btn-danger" href="${link}" role="button" style="float: right;">Main menu</a>
</div>
</body>
</html>
