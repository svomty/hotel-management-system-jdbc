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
    <title>Заселенные в гостиницу</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
    <h2>Список заселенных в гостиницу</h2>
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
    <a class="btn btn-success" href="${addURL }" role="button">Заселить гостя</a>
    <spring:url value="/" var="link"/>
    <a class="btn btn-danger" href="${link}" role="button" style="float: right;">Главное меню</a>
</div>
</body>
</html>
