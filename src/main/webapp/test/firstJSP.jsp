<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Timur
  Date: 07.05.2023
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<%@ page import="java.util.Date, logic.TestClass" %>
<h1>Testing JSP</h1>
<p>
    <%
        for (int i = 0; i < 10; ++i)
            out.println("<p>" + "Hello " + i + "</p>");
    %>
</p>
<p>
        <% TestClass testClass = new TestClass(); %>
        <%=
            testClass.getInfo()
        %>
<p>
    <%=
    new Date() + "\n"
    %>
</p>
<p>
    <%="Hello people it is just simple String "%>
</p>
</body>
</html>