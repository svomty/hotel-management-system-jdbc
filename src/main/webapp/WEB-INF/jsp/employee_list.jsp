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

    <table class="table table-striped">
        <tr>
            <td><h2>Users list</h2></td>
            <td>
                <div align="right">
                    <form action="/reports/employee">
                        <button style="width:100%;" class="btn btn-dark" type="submit">Make report</button>
                    </form>
                </div>
            </td>
        </tr>
    </table>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="row">User Id</th>
            <th scope="row">Last name</th>
            <th scope="row">First name</th>
            <th scope="row">Patronymic</th>
            <th scope="row">Gender</th>
            <th scope="row">Phone</th>
            <th scope="row">Home address</th>
            <th scope="row">Passport data</th>
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
    <a class="btn btn-success" href="${addURL }" role="button">Add new user</a>
    <spring:url value="/" var="link"/>
    <a class="btn btn-danger" href="${link}" role="button" style="float: right;">Main menu</a>
</div>
</body>
</html>