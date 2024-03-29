<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 17.11.2019
  Time: 6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check into a hotel</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body>

<form:form modelAttribute="zaseleniyeForm" method="post" action="add" cssClass="form">
    <form:hidden path="iteration_type" value="zaseleniye"/>
    <table>
        <tr>
            <td>Select a user to check in:</td>
            <td>
                <c:choose>
                    <c:when test="${empty rooms}">
                        <form:select path="user_id" name="users" id="users" cssClass="form-control">
                            <c:forEach items="${employee_list}" var="user">
                                <form:option value="${user.employeeId}">
                                    <c:out value="${user.lastName} ${user.firstName} ${user.patronymic} [${user.passportId}]"/>
                                </form:option>
                            </c:forEach>
                        </form:select>
                    </c:when>
                    <c:otherwise>
                        <form:input path="user_id" cssClass="form-control" name="users" id="users"
                                    value="${zaseleniyeForm.user_id}" readonly="true"/>
                    </c:otherwise>
                </c:choose>

            </td>
        </tr>
        <tr>
            <td>Start date:</td>
            <td>
                <c:choose>
                    <c:when test="${empty rooms}">
                        <form:input type="date" name="start" id="start" path="start_date" cssClass="form-control"/>
                    </c:when>
                    <c:otherwise>
                        <form:input type="date" name="start" id="start" path="start_date" cssClass="form-control"
                                    value="${date}" readonly="true"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>Final date:</td>
            <td>
                <c:choose>
                    <c:when test="${empty rooms}">
                        <form:input type="date" name="final" id="final" path="final_date" cssClass="form-control"/>
                    </c:when>
                    <c:otherwise>
                        <form:input type="date" name="final" id="final" path="final_date" cssClass="form-control"
                                    value="${date2}" readonly="true"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${empty rooms}">
                    <form:button type="submit" class="btn btn-primary">Search available apartments</form:button>
                </c:if>

            </td>
        </tr>
        <c:if test="${!empty rooms}">
            <tr>
                <td>
                    Apartment selection:
                </td>
                <td>
                    <form:select path="room" name="rooms" id="rooms" cssClass="form-control">
                        <c:forEach items="${rooms}" var="room">
                            <form:option value="${room.id}">
                                <c:out value="[${room.id}] Rooms:${room.roomCells} Places:${room.userCells}
                                    Total price:${room.price*room.userCells} Price for one place: ${room.price}"/>
                            </form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
        </c:if>
    </table>
    <c:if test="${!empty rooms}">
        <form:button type="submit" class="btn btn-primary">Check into a hotel</form:button>
    </c:if>

</form:form>

<script type="text/javascript">
    function setInputDate(_id, count) {
        var _dat = document.querySelector(_id);
        var hoy = new Date(),
            d = hoy.getDate() + count,
            m = hoy.getMonth() + 1,
            y = hoy.getFullYear(),
            data;

        if (d < 10) {
            d = "0" + d;
        }
        ;
        if (m < 10) {
            m = "0" + m;
        }
        ;

        data = y + "-" + m + "-" + d;
        _dat.value = data;
    };

    <c:if test="${empty rooms}">
    setInputDate("#start", 0);
    setInputDate("#final", 1);
    </c:if>

</script>
</body>
</html>
