<%@ page isELIgnored="false" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <c:if test="${empty apartmentForm.id}">
        <spring:url value="/confidential/apartment/save" var="saveURL"/>
        <h2>Apartment</h2>
    </c:if>
    <c:if test="${!empty apartmentForm.id}">
        <c:url value="/confidential/apartment/edit" var="saveURL"/>
        <h2>Apartment №${apartmentForm.id}</h2>
    </c:if>

    <form:form modelAttribute="apartmentForm" method="post" action="${saveURL}" cssClass="form">
        <div class="form-group">
            <c:choose>
            <c:when test="${empty apartmentForm.id}">
                <lable for="id">Номер комнаты</lable>
                <form:input path="id" cssClass="form-control" id="id"/>
            </c:when>
            <c:otherwise>
                <form:hidden path="id" cssClass="form-control" id="id"/>
            </c:otherwise>
        </c:choose>
        </div>
        <div class="form-group">
            <lable for="userCells">Количество мест</lable>
            <form:input path="userCells" cssClass="form-control" id="userCells"/>
        </div>
        <div class="form-group">
            <lable for="roomCells">Количество комнат</lable>
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
