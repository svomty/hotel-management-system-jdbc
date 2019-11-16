<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employees</title>
    <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <spring:url value="/employee/save" var="saveURL"/>
    <h2>Employee</h2>
    <form:form modelAttribute="employeeForm" method="post" action="${saveURL }" cssClass="form">
    <form:hidden path="employeeId"/>
    <div class="form-group">
        <lable for="lastName">Фамилия</lable>
        <form:input path="lastName" cssClass="form-control" id="lastName"/>
    </div>
    <div class="form-group">
        <lable for="firstName">Имя</lable>
        <form:input path="firstName" cssClass="form-control" id="firstName"/>
    </div>
    <div class="form-group">
        <lable for="patronymic">Отчество</lable>
        <form:input path="patronymic" cssClass="form-control" id="patronymic"/>
    </div>
    <div class="form-group">
        <lable for="gender">Пол</lable>
        <form:input path="gender" cssClass="form-control" id="gender"/>
    </div>
    <div class="form-group">
        <lable for="phone">Контактный телефон</lable>
        <form:input path="phone" cssClass="form-control" id="phone"/>
    </div>
    <div class="form-group">
        <lable for="address">Домашний адрес</lable>
        <form:input path="address" cssClass="form-control" id="address"/>
    </div>
    <div class="form-group">
        <lable for="passportId">Идентификатор паспорта</lable>
        <form:input path="passportId" cssClass="form-control" id="passportId"/>
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
</form:form>
</div>
</body>
</html>