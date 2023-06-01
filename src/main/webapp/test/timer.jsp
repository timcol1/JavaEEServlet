<%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 12.05.2023
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Timing</title>
</head>
<body>
<h1>Счетчик времени от запуска приложения до нажатия кнопки</h1>
<form name="Simple" action="timeaction" method="POST">
    <input type="hidden" name="time" value="${System.currentTimeMillis()}"/>
    <input type="submit" name="button" value="Посчитать время" />
</form>
</body>
</html>