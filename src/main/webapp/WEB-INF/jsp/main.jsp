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
        h1 {
            color: green;
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
            color: white; /* Белые буквы */
            border-radius: 0 10px;
        }
    </style>
</head>
<body>
<h1 align="center">Главное меню</h1>
<table border="0" width="300px" cellpadding="0">
    <tr>
        <th>
            <form action="/apartment/list">
                <button style="width:100%; height:40px;" type="submit">Список апартаментов</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/employee/list">
                <button style="width:100%; height:40px;" type="submit">Список клиентов</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/employee/list">
                <button style="width:100%; height:40px;" type="submit">Бронирование гостиницы</button>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            <form action="/employee//list">
                <button style="width:100%; height:40px;" type="submit">Заселение в гостиницу</button>
            </form>
        </th>
    </tr>
</table>
</body>
</html>
