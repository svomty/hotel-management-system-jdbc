<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="pd4ml" uri="http://pd4ml.com/tlds/4.0" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal"/>
    <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
        <pd4ml:transform
                screenWidth="1000"
                pageFormat="A4"
                pageOrientation="landscape"
                pageInsets="50,15,15,15,points"
                inline="true"
                fileName="employees.pdf">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>employees.pdf"</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                      crossorigin="anonymous">
            </head>
            <body>
            <div class="container">
                <h2 align="center">Employee list</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="row">EmployeeId</th>
                        <th scope="row">LastName</th>
                        <th scope="row">FirstName</th>
                        <th scope="row">Patronymic</th>
                        <th scope="row">Gender</th>
                        <th scope="row">Phone</th>
                        <th scope="row">Address</th>
                        <th scope="row">Passport</th>
                        <th scope="row">Password</th>
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
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div align="right">${date}</div>
            </div>
            </body>
        </pd4ml:transform>
    </sec:authorize>
</sec:authorize>
</html>