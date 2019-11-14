<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Apartments</title>
    <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <spring:url value="/apartment/save" var="saveURL"/>
    <h2>Apartment</h2>
    <form:form modelAttribute="apartmentForm" method="post" action="${saveURL }" cssClass="form">
        <div class="form-group">
            <lable for="id">Номер комнаты</lable>
            <form:input path="id" cssClass="form-control" id="id"/>
        </div>
        <div class="form-group">
            <lable for="userCells">Количество мест</lable>
            <form:input path="userCells" cssClass="form-control" id="userCells"/>
        </div>
        <div class="form-group">
            <lable for="roomCells">Количесто комнат</lable>
            <form:input path="roomCells" cssClass="form-control" id="roomCells"/>
        </div>
        <div class="form-group">
            <lable for="price">Цена за одно место</lable>
            <form:input path="price" cssClass="form-control" id="price"/>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>
</body>
</html>
