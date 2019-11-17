<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 17.11.2019
  Time: 6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заселение</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<table>
    <tr>
        <td>Выбрать пользователя для заселения</td>
        <td>
            <select name="users">
                <c:forEach items="${users}" var="users">
                    <option value="${users.id}"><c:out value="${users.name}" /></option>
                </c:forEach>
            </select>
        </td>
    </tr>
</table>
</body>
</html>
