<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 17.11.2019
  Time: 6:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Reviews</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/bootstrap.min.css"/>" rel="stylesheet">
    <style>
        .container3 {
            border: 2px solid #ccc;
            background-color: #eee;
            border-radius: 5px;
            padding: 16px;
            margin: 16px 0;
        }

        .container2 {
            padding: 16px;
            margin: 16px 0;
        }

        .container3::after {
            content: "";
            clear: both;
            display: table;
        }

        .container3 img {
            float: left;
            margin-right: 20px;
            border-radius: 50%;
        }

        .container3 span {
            font-size: 20px;
            margin-right: 15px;
        }

        @media (max-width: 500px) {
            .container3 {
                text-align: center;
            }

            .container3 img {
                margin: auto;
                float: none;
                display: block;
            }
        }

        .alignleft {
            float: left;
        }

        .alignright {
            float: right;
        }
    </style>
</head>
<body>
<c:set var="salary" scope="session" value="  "/>
<div class="container2">
    <h2 style="align:center;" class="alignleft">Reviews</h2>
    <spring:url value="/" var="link"/>
    <a class="btn btn-primary alignright" href="${link}" role="button">Main menu</a>
</div>
<br>
<c:forEach items="${reviews}" var="review">
    <div class="container3">
        <img src="https://www.seekpng.com/png/detail/41-410093_circled-user-icon-user-profile-icon-png.png" alt="Avatar"
             style="width:90px">
        <p><c:forEach items="${employee_list }" var="employee">
            <c:if test="${employee.employeeId eq review.user_id}">
                <span>${employee.firstName}.</span>
            </c:if>
        </c:forEach> <c:forEach begin="1" end="${review.mark}" varStatus="loop">★</c:forEach><c:forEach
                begin="${review.mark+1}" end="5" varStatus="loop">✰</c:forEach>
            <sec:authorize access="isAuthenticated()">
            <sec:authentication var="principal" property="principal"/>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <c:forEach items="${employee_list }" var="employee">
            <c:if test="${review.user_id eq employee.employeeId}">
            <c:if test="${principal.username eq employee.passportId}">
            <c:set var="salary" scope="session" value="${employee.password}"/>
            <spring:url
                    value="/reviews/delete/${review.id }" var="deleteURL"/>
            <a class="btn btn-danger alignright" href="${deleteURL }" role="button">Delete review</a></p>
        </c:if>
        </c:if>
        </c:forEach>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
            <spring:url
                    value="/reviews/delete/${review}" var="deleteURL"/>
            <a class="btn btn-danger alignright" href="${deleteURL }" role="button">Delete review</a></p>
        </sec:authorize>
        </sec:authorize>
        <p>${review.text}</p>
    </div>
</c:forEach>
<sec:authorize access="isAuthenticated()">
    <sec:authorize access="!hasRole('ROLE_SUPERADMIN')">
        <sec:authentication var="principal" property="principal"/>
        <c:forEach items="${employee_list }" var="employee">
            <c:if test="${principal.username eq employee.passportId}">
                <c:if test="${!salary.equals(principal.username)}">
                    <form:form modelAttribute="reviewForm" method="post" action="${saveURL }" cssClass="form">
                        <div class="container3">
                            <span>Write a review</span>
                            <form:hidden path="user_id" value="${employee.employeeId}"/>
                            <p>Rate the hotel on a scale of 1 to 5: <form:input path="mark" cssClass="form-control"
                                                                                value="5"
                                                                                type="number" name="quantity" min="1"
                                                                                max="5"/></p>
                            <p>Comment:<Br><form:textarea path="text" cssClass="form-control" cols="40" rows="3"/></p>
                            <input type="submit" class="btn btn-success" value="Add a review">
                        </div>
                    </form:form>
                </c:if>
            </c:if>
        </c:forEach>
    </sec:authorize>
</sec:authorize>

</body>
</html>
