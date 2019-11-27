<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee List</title>
    <link href="<c:url value="/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">

    <table  class="table table-striped">
        <tr>
            <td><h2>Список клиентов</h2></td>
            <td>
                <div align="right">
                    <form action="/reports/employee">
                        <button style="width:100%;" class="btn btn-dark" type="submit">Сделать отчет</button>
                    </form>
                </div>
            </td>
        </tr>
    </table>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="row">Идентификатор пользователя</th>
            <th scope="row">Фамилия</th>
            <th scope="row">Имя</th>
            <th scope="row">Отчество</th>
            <th scope="row">Пол</th>
            <th scope="row">Телефон</th>
            <th scope="row">Адрес</th>
            <th scope="row">Номер паспорта</th>
            <th scope="row">Password</th>
            <th scope="row">Edit</th>
            <th scope="row">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employee_list }" var="employee">
            <tr>
                <td>${employee.employeeId }</td>
                <td>${employee.lastName }</td>
                <td>${employee.firstName }</td>
                <td>${employee.patronymic }</td>
                <td>${employee.gender }</td>
                <td>${employee.phone }</td>
                <td>${employee.address }</td>
                <td>${employee.passportId }</td>
                <td>${employee.password }</td>
                <td>
                    <spring:url value="/confidential/employee/update/${employee.employeeId }" var="updateURL"/>
                    <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
                </td>
                <td>
                    <spring:url value="/confidential/employee/delete/${employee.employeeId }" var="deleteURL"/>
                    <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/confidential/employee/add" var="addURL"/>
    <a class="btn btn-success" href="${addURL }" role="button">Добавить нового клиента</a>
    <spring:url value="/" var="link"/>
    <a class="btn btn-danger" href="${link}" role="button" style="float: right;">Главное меню</a>
</div>
</body>
</html>