<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee List</title>
    <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<div class="container">
    <h2>Employee List</h2>
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
            <th scope="row">Edit</th>
            <th scope="row">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employee_list }" var="employee" >
            <tr>
                <td>${employee.employeeId }</td>
                <td>${employee.lastName }</td>
                <td>${employee.firstName }</td>
                <td>${employee.patronymic }</td>
                <td>${employee.gender }</td>
                <td>${employee.phone }</td>
                <td>${employee.address }</td>
                <td>${employee.passportId }</td>
                <td>
                    <spring:url value="/employee/update/${employee.employeeId }" var="updateURL" />
                    <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
                </td>
                <td>
                    <spring:url value="/employee/delete/${employee.employeeId }" var="deleteURL" />
                    <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/employee/add" var="addURL" />
    <a class="btn btn-primary" href="${addURL }" role="button">Add New Employee</a>
</div>
</body>
</html>