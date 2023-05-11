<%@ page import="avlyalkulov.timur.javaeetest.servlets.Basket" %><%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 11.05.2023
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Basket</title>
</head>
<body>
<%@ page import="avlyalkulov.timur.javaeetest.servlets.Basket" %>
<% Basket basket = (Basket) session.getAttribute("basket"); %>
<p>Имя товара <%=  basket.getNameProduct()%>
</p>
<p>Его количество <%= basket.getQuantity()%>
</p>
</body>
</html>
