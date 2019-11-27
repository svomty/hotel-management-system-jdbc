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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <spring:url value="/confidential/employee/save" var="saveURL"/>
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
            <form:select path="gender" name="gender" id="gender" cssClass="form-control">
                <form:option value="male">male</form:option>
                <form:option value="female">female</form:option>
            </form:select>
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
        <div class="form-group">
            <lable for="password">Пароль</lable>
            <form:input path="password" cssClass="form-control" id="password"/>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>