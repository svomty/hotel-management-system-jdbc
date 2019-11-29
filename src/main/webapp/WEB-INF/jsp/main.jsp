<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 14.11.2019
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <style>
        body {
            background: darkgray;
            color: black;
        }

        table {
            width: 300px; /* Ширина таблицы */
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }

        td {
            text-align: center; /* Выравниваем текст по центру ячейки */
        }

        button {
             background: green; /* Синий цвет фона */
             color: springgreen; /* Белые буквы */
             border-radius: 0 10px;
             border: 2px solid springgreen;
        }

        button:disabled {
            background: gray;
            color: springgreen;
            border-radius: 0 10px;
            border: 2px solid springgreen;
        }

        button:disabled:hover {
            background: gray;
            color: springgreen;
            border-radius: 0 10px;
            border: 2px solid springgreen;
        }

        button:hover {
            background: darkgreen;
        }

        #hello {
            color: black;
            position: absolute;
            bottom: 1em;
            right: 1em;
            text-align: right;
        }
    </style>
</head>
<body>

<%
    if (request.isUserInRole("ROLE_SUPERADMIN")){
        javax.servlet.http.Cookie cookieRole = new javax.servlet.http.Cookie("role", "ROLE_SUPERADMIN");
        response.addCookie(cookieRole);
        javax.servlet.http.Cookie cookieLogin
                = new javax.servlet.http.Cookie("login", null);
        response.addCookie(cookieLogin);
    } else if (request.isUserInRole("ROLE_ADMIN")){
        javax.servlet.http.Cookie cookieRole = new javax.servlet.http.Cookie("role", "ROLE_ADMIN");
        response.addCookie(cookieRole);
        javax.servlet.http.Cookie cookieLogin
                = new javax.servlet.http.Cookie("login", request.getUserPrincipal().getName());
        response.addCookie(cookieLogin);
    }else {
        javax.servlet.http.Cookie cookieRole = new javax.servlet.http.Cookie("role", "ROLE_DEFAULT");
        response.addCookie(cookieRole);
        javax.servlet.http.Cookie cookieLogin
                = new javax.servlet.http.Cookie("login", null);
        response.addCookie(cookieLogin);
    }
%>

<h1 align="center">Main menu</h1>
<table border="0" width="300px" cellpadding="0">
<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal"/>
    <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
    <tr>
        <th>
            <form action="/confidential/apartment/list">
                <button style="width:100%; height:40px;" type="submit">Apartments list</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/confidential/employee/list">
                <button style="width:100%; height:40px;" type="submit">Users list</button>
            </form>
        </th>
    </tr>
        <tr>
            <th>
                <form action="/protected/reservation/list">
                    <button style="width:100%; height:40px;" type="submit">Hotel reservation</button>
                </form>
            </th>
        </tr>
        <tr>
            <th>
                <form action="/confidential/zaseleniye/list">
                    <button style="width:100%; height:40px;" type="submit">Check into a hotel</button>
                </form>
            </th>
        </tr>
    </sec:authorize>
</sec:authorize>


    <sec:authorize access="isAuthenticated()">
        <sec:authentication var="principal" property="principal"/>
        <sec:authorize access="!hasRole('ROLE_SUPERADMIN')">
            <tr>
                <th>
                    <form action="/confidential/apartment/list">
                        <button style="width:100%; height:40px;" type="submit" disabled>Apartments list</button>
                    </form>
                </th>
            </tr>
            <tr>
                <th>
                    <form action="/confidential/employee/list">
                        <button style="width:100%; height:40px;" type="submit" disabled>Users list</button>
                    </form>
                </th>
            </tr>
            <tr>
                <th>
                    <form action="/protected/reservation/list">
                        <button style="width:100%; height:40px;" type="submit">Hotel reservation</button>
                    </form>
                </th>
            </tr>
            <tr>
                <th>
                    <form action="/confidential/zaseleniye/list">
                        <button style="width:100%; height:40px;" type="submit" disabled>Check into a hotel</button>
                    </form>
                </th>
            </tr>
        </sec:authorize>
    </sec:authorize>


<sec:authorize access="!isAuthenticated()">
    <tr>
        <th>
            <form action="/confidential/apartment/list">
                <button style="width:100%; height:40px;" type="submit" disabled>Apartments list</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/confidential/employee/list">
                <button style="width:100%; height:40px;" type="submit" disabled>Users list</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/protected/reservation/list">
                <button style="width:100%; height:40px;" type="submit" disabled>Hotel reservation</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/confidential/zaseleniye/list">
                <button style="width:100%; height:40px;" type="submit" disabled>Check into a hotel</button>
            </form>
        </th>
    </tr>
</sec:authorize>
    <tr>
        <th>
            <form action="/reviews/list">
                <button style="width:100%; height:40px;" type="submit">Reviews</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <sec:authorize access="isAuthenticated()">
                <form action="/logout">
                    <button type="submit" style="background:darkred;color:palevioletred;
                    border: 2px solid red;width:100%; height:40px;">Sign out</button>
                </form>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <form action="/login">
                    <button type="submit" style="background:blue;color:deepskyblue;
                    border: 2px solid deepskyblue;width:100%; height:40px;">Account Login</button>
                </form>
            </sec:authorize>
        </th>
    </tr>
</table>

<sec:authorize access="isAuthenticated()">
    <sec:authentication var="principal" property="principal"/>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <c:forEach items="${employee_list }" var="employee">
            <c:if test="${principal.username eq employee.passportId}">
                <span id="hello">Hello, ${employee.firstName} ${employee.patronymic}</span>
            </c:if>
        </c:forEach>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
        <span id="hello">Hello, ${principal.username}</span>
    </sec:authorize>
</sec:authorize>

</body>
</html>
