<%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 09.05.2023
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parameter JSP</title>
</head>
<body>
<h1>
    <%="Testing Parameter JSP"%>
</h1>
<h1>
    <%
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
    %>
    <%= "Hello it is parameter example your name - " + name + " And surname is " + surname%>
</h1>
</body>
</html>
