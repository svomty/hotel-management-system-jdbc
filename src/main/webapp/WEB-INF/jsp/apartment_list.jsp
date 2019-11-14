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
    <h2>Apartment List</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="row">Номер комнаты</th>
            <th scope="row">Количество мест</th>
            <th scope="row">Количество комнат</th>
            <th scope="row">Стоимость за одно место</th>
            <th scope="row">Edit</th>
            <th scope="row">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${apartment_list }" var="apartment" >
            <tr>
                <td>${apartment.id }</td>
                <td>${apartment.userCells }</td>
                <td>${apartment.roomCells }</td>
                <td>${apartment.price }</td>
                <td>
                    <spring:url value="/apartment/update/${apartment.id }" var="updateURL" />
                    <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
                </td>
                <td>
                    <spring:url value="/apartment/delete/${apartment.id }" var="deleteURL" />
                    <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/apartment/add" var="addURL" />
    <a class="btn btn-primary" href="${addURL }" role="button">Add New Apartment</a>
</div>
</body>
</html>