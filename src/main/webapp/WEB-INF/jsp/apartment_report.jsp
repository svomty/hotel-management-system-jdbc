<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="pd4ml" uri="http://pd4ml.com/tlds/4.0" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal"/>
    <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
        <pd4ml:transform
                screenWidth="700"
                pageFormat="A4"
                pageOrientation="portrait"
                pageInsets="15,15,15,15,points"
                inline="true"
                fileName="apartments.pdf">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>apartments.pdf</title>
                <link href="<c:url value="/bootstrap.min.css"/>" rel="stylesheet">
            </head>
            <body>
            <div class="container">
                <h2 align="center">Apartments</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="row">Number</th>
                        <th scope="row">Count</th>
                        <th scope="row">Room</th>
                        <th scope="row">Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${apartment_list }" var="apartment">
                        <tr>
                            <td>${apartment.id }</td>
                            <td>${apartment.userCells }</td>
                            <td>${apartment.roomCells }</td>
                            <td>${apartment.price }</td>
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
